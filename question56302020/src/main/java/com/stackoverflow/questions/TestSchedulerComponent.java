package com.stackoverflow.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestSchedulerComponent {
    @Autowired
    private CustomDynamicSchedule dynamicSchedule;

    @Scheduled(fixedDelay = 5000)
    public void testMethod() {
        System.out.println("TestSchedulerComponent " + new Date());
        dynamicSchedule.delay(1000l);
        dynamicSchedule.increaseDelayInterval(9000l);
        dynamicSchedule.decreaseDelayInterval(5000l);
    }
}
