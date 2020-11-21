package com.wty.manager;

import com.wty.job.QuartzJob;
import com.wty.job.ScheduleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wty
 * @date 2020/8/24 23:13
 */
@Configuration
public class QuartzManager {

    /**
     * 使用jobDetail包装job
     *
     * @return
     */
    @Bean
    public JobDetail quartzJob() {
        return JobBuilder.newJob(QuartzJob.class)
                .withIdentity("quartzJob")
                .storeDurably()
                .build();
    }

    /**
     * 使用jobDetail包装job
     *
     * @return
     */
    @Bean
    public JobDetail scheduleJob() {
        return JobBuilder.newJob(ScheduleJob.class)
                .withIdentity("scheduleJob")
                .storeDurably()
                .build();
    }

    /**
     * 把jobDetail注册到trigger上去
     *
     * @return
     */
    @Bean
    public Trigger quartzJobTrigger() {
        //每隔15秒运行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(15).repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(quartzJob())
                .withIdentity("quartzJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * @return
     */
    @Bean
    public Trigger scheduleJobTrigger() {
        //cron方式,每隔5秒执行一次
        return TriggerBuilder.newTrigger().forJob(scheduleJob())
                .withIdentity("scheduleJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();
    }

}
