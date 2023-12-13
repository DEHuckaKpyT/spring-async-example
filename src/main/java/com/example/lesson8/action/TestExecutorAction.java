package com.example.lesson8.action;

import com.example.lesson8.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created on 13.12.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@Component
@RequiredArgsConstructor
public class TestExecutorAction {

    private final DataService service;

    @Async("testExecutor")
    public void execute() {
        sleep(1_000);
        service.save("after 1 second");
    }

    @SneakyThrows
    private void sleep(long milliseconds) {
        Thread.sleep(milliseconds);
    }
}
