package com.wty.listener;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

@Slf4j
public class MyTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        String name = getClass().getSimpleName();
        log.info("获取监听器名称：" + name);
        return name;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        String triggerName = trigger.getKey().getName();
        log.info(triggerName + "was fired");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        String triggerName = trigger.getKey().getName();
        log.info(triggerName + "was not vetoed");
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        String triggerName = trigger.getKey().getName();
        log.info(triggerName + " misfired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        String triggerName = trigger.getKey().getName();
        log.info(triggerName + " is complete");
    }
}
