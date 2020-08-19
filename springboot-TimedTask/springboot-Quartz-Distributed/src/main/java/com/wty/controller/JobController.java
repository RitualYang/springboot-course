package com.wty.controller;

import com.sun.istack.internal.NotNull;
import com.wty.entity.JobEntity;
import com.wty.mapper.JobEntityMapper;
import com.wty.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Set;

@RestController
@Slf4j
public class JobController {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private JobService jobService;
    @Autowired
    private JobEntityMapper jobEntityMapper;

    //初始化启动所有的Job
    @PostConstruct
    public void initialize() {
        try {
            reStartAllJobs();
            log.info("init success");
        } catch (SchedulerException e) {
            log.error("printStackTrace ", e);
        }
    }

    //根据ID重启某个Job
    @RequestMapping("/refresh/{id}")
    public String refresh(@PathVariable @NotNull Integer id) throws SchedulerException {
        String result;
        JobEntity entity = jobService.getJobEntityById(id);
        if (Objects.isNull(entity)) {
            return "error: id is not exist ";
        }
        synchronized (log) {
            JobKey jobKey = jobService.getJobKey(entity);
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            scheduler.pauseJob(jobKey);
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()));
            scheduler.deleteJob(jobKey);
            JobDataMap map = jobService.getJobDataMap(entity);
            JobDetail jobDetail = jobService.getJobDetail(jobKey, entity.getDescription(), map);
            if (entity.getStatus().equals("OPEN")) {
                scheduler.scheduleJob(jobDetail, jobService.getTrigger(entity));
                result = "Refresh Job : " + entity.getName() + "\t jarPath: " + entity.getJarPath() + " success !";
            } else {
                result = "Refresh Job : " + entity.getName() + "\t jarPath: " + entity.getJarPath() + " failed ! , " +
                        "Because the Job status is " + entity.getStatus();
            }
        }
        return result;
    }


    //重启数据库中所有的Job
    @RequestMapping("/refresh/all")
    public String refreshAll() {
        String result;
        try {
            reStartAllJobs();
            result = "success";
        } catch (SchedulerException e) {
            result = "exception : " + e.getMessage();
        }
        return "refresh all jobs : " + result;
    }

    /**
     * 重新启动所有的job
     */
    private void reStartAllJobs() throws SchedulerException {
        synchronized (log) {                                                         //只允许一个线程进入操作
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            Set<JobKey> set = scheduler.getJobKeys(GroupMatcher.anyGroup());
            scheduler.pauseJobs(GroupMatcher.anyGroup());                               //暂停所有JOB
            for (JobKey jobKey : set) {                                                 //删除从数据库中注册的所有JOB
                scheduler.unscheduleJob(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()));
                scheduler.deleteJob(jobKey);
            }
            for (JobEntity job : jobService.loadJobs()) {                               //从数据库中注册的所有JOB
                log.info("Job register name : {} , group : {} , cron : {}", job.getName(), job.getJobGroup(), job.getJobCron());
                JobDataMap map = jobService.getJobDataMap(job);
                JobKey jobKey = jobService.getJobKey(job);
                JobDetail jobDetail = jobService.getJobDetail(jobKey, job.getDescription(), map);
                if (job.getStatus().equals("OPEN")) {
                    scheduler.scheduleJob(jobDetail, jobService.getTrigger(job));
                } else {
                    log.info("Job jump name : {} , Because {} status is {}", job.getName(), job.getName(), job.getStatus());
                }
            }
        }
    }

    //修改某个Job执行的Cron
    @PostMapping("/modifyJob")
    public String modifyJob(@RequestBody Integer id,String cron) {
        if (!CronExpression.isValidExpression(cron)) {
            return "cron is invalid !";
        }
        synchronized (log) {
            JobEntity job = jobService.getJobEntityById(id);
            if (job.getStatus().equals("OPEN")) {
                try {
                    JobKey jobKey = jobService.getJobKey(job);
                    TriggerKey triggerKey = new TriggerKey(jobKey.getName(), jobKey.getGroup());
                    Scheduler scheduler = schedulerFactoryBean.getScheduler();
                    CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                    String oldCron = cronTrigger.getCronExpression();
                    if (!oldCron.equalsIgnoreCase(cron)) {
                        job.setJobCron(cron);
                        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
                        CronTrigger trigger = TriggerBuilder.newTrigger()
                                .withIdentity(jobKey.getName(), jobKey.getGroup())
                                .withSchedule(cronScheduleBuilder)
                                .usingJobData(jobService.getJobDataMap(job))
                                .build();
                        scheduler.rescheduleJob(triggerKey, trigger);
                        jobEntityMapper.updateByPrimaryKey(job);
                    }
                } catch (Exception e) {
                    log.error("printStackTrace", e);
                }
            } else {
                log.info("Job jump name : {} , Because {} status is {}", job.getName(), job.getName(), job.getStatus());
                return "modify failure , because the job is closed";
            }
        }
        return "modify success";
    }
}
