package com.example.lesson8.action;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallerAction {

    private final AsyncAction action;

    public void execute() {
        action.execute();
        log.info(LocalDateTime.now() + " from caller action");
    }
}
