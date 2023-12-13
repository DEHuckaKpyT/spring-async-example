package com.example.lesson8.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@Slf4j
@Component
public class RateScheduler {

    int counter = 0;

    @Scheduled(fixedRateString = "${rate-scheduler}")
    public void runEvery2Seconds() {
        counter++;
        log.info("counter value: " + counter);
    }
}
