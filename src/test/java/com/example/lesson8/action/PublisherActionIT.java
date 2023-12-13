package com.example.lesson8.action;

import com.example.lesson8.listener.ExampleEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@SpringBootTest
public class PublisherActionIT {

    @Autowired
    private PublisherAction action;

    @Test
    void test() {
        // Arrange
        ExampleEvent argument = ExampleEvent.of("on example event");

        // Act
        action.execute(argument);
    }
}
