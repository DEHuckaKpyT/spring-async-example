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
public class ExampleScheduler {

    /**
     * <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronExpression.html">cron examples</a>
     * <a href="https://stackoverflow.com/questions/26147044/spring-cron-expression-for-every-day-101am">cron examples</a>
     * <pre>
     * ┌───────────── second (0-59)
     * │ ┌───────────── minute (0 - 59)
     * │ │ ┌───────────── hour (0 - 23)
     * │ │ │ ┌───────────── day of the month (1 - 31)
     * │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
     * │ │ │ │ │ ┌───────────── day of the week (0 - 7)
     * │ │ │ │ │ │          (0 or 7 is Sunday, or MON-SUN)
     * │ │ │ │ │ │
     * * * * * * *
     * </pre>
     */
    @Scheduled(cron = "${cron.example}")
    public void runFromProperties() {
        log.info("scheduled by cron");
    }
}
