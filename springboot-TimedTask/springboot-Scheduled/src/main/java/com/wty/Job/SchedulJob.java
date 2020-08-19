package com.wty.Job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulJob {

    @Scheduled(cron = "*/5 * * * * *") //每5秒执行一次
    public void logJob(){
        log.info("-----定时任务调度----");
    }
    //initialDelay：启动后多久开始执行,单位时毫秒
    //fixedDelay：下次执行时间,fixedDelay等任务进行完了才开始计时
    //fixedRate：下次执行时间,任务开始运行的时候就计时。
    @Scheduled(initialDelay = 1000 * 10,fixedDelay = 1000 * 10)//固定间隔任务
    public void printlnJob(){
        System.out.println("----固定间隔任务----");
    }

    @Scheduled(initialDelay = 1000 * 10,fixedRate = 1000)//固定频率任务
    public void printJob(){
        System.out.print("----固定频率任务----");
    }

}
