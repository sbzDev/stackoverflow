package com.stackoverflow.questions;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

public class CustomDynamicSchedule  implements Trigger {

    private TaskScheduler taskScheduler;
    private ScheduledFuture<?> schedulerFuture;

    /**
     * milliseconds
     */
    private long delayInterval;

    public CustomDynamicSchedule(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }


    public void increaseDelayInterval(Long delay) {
        System.out.println("increaseDelayInterval");
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval += delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }


    public void decreaseDelayInterval(Long delay) {
        System.out.println("decreaseDelayInterval");
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval += delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }


    public void delay(Long delay) {
        System.out.println("delay");
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval = delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }


    public Date nextExecutionTime(TriggerContext triggerContext) {
        System.out.println("nextExecutionTime");
        Date lastTime = triggerContext.lastActualExecutionTime();
        return (lastTime == null) ? new Date() : new Date(lastTime.getTime() + delayInterval);
    }

}
