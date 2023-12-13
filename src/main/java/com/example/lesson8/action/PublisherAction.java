package com.example.lesson8.action;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PublisherAction {

    private final ApplicationEventPublisher publisher;

    public void execute(Object event) {
        log.info("in publisher action 1");
        publisher.publishEvent(event);
        sleep(1_000);
        log.info("in publisher action 2");
    }

    @SneakyThrows
    private void sleep(long milliseconds) {
        Thread.sleep(milliseconds);
    }
}
