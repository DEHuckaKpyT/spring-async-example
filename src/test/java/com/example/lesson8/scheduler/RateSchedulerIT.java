package com.example.lesson8.scheduler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@SpringBootTest
@TestPropertySource(properties = {
        "rate-scheduler=2000"
})
public class RateSchedulerIT {

    @Autowired
    private RateScheduler scheduler;

    @BeforeEach
    void setUp() {
        scheduler.counter = 0;
    }

    @Test
    void test() {
        // Assert
        await().atMost(6_100, SECONDS)
               .until(() -> scheduler.counter == 3);
    }
}
