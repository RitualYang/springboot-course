package com.wty.manager;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuartzManager {
    @Autowired
    private Scheduler schedule;
}
