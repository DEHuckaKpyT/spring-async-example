package com.example.lesson8.listener;

import com.example.lesson8.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
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
public class ExampleListener {

    private final DataService service;

    @EventListener
    public void onEvent(ExampleEvent event) throws InterruptedException {
        log.info(event.getName() + " 1");
        Thread.sleep(1_000);
        service.save(event.getName() + " 2");
    }
}
