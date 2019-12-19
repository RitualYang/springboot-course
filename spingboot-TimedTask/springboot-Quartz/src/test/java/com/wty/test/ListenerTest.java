package com.wty.test;


import com.wty.job.QuartzJob;
import com.wty.listener.MyJobListener;
import com.wty.listener.MyTriggerListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListenerTest {

    @Test
    public void testJobListener() throws SchedulerException {

        JobDetail quartzJob = JobBuilder.newJob(QuartzJob.class)
                .withIdentity("quartzJob")
                .storeDurably()
                .build();
        SimpleTrigger quartzTrigger = TriggerBuilder.newTrigger()
                .withIdentity("quartzTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever()).build();

        SchedulerFactory factory = new StdSchedulerFactory();

        Scheduler scheduler = factory.getScheduler();
        //绑定关系：可以1：N
        scheduler.scheduleJob(quartzJob,quartzTrigger);

        //创建并注册一个全局的Job Listener
        scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());


        //启动
        scheduler.start();
    }

    @Test
    public void testTriggerListener() throws SchedulerException {

        JobDetail quartzJob = JobBuilder.newJob(QuartzJob.class)
                .withIdentity("quartzJob")
                .storeDurably()
                .build();
        SimpleTrigger quartzTrigger = TriggerBuilder.newTrigger()
                .withIdentity("quartzTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever()).build();

        SchedulerFactory factory = new StdSchedulerFactory();

        Scheduler scheduler = factory.getScheduler();
        //绑定关系：可以1：N
        scheduler.scheduleJob(quartzJob,quartzTrigger);

        //创建并注册一个全局的Trigger Listener
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(), EverythingMatcher.allTriggers());

        //启动
        scheduler.start();
    }


}
