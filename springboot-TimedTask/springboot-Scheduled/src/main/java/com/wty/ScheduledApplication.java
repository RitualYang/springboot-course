package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启Scheduled定时任务
@SpringBootApplication
public class ScheduledApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class,args);
    }
}
