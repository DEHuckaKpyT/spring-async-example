package com.example.lesson8.action;

import com.example.lesson8.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

/**
 * Created on 13.12.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@SpringBootTest
class TestExecutorActionIT {

    @Autowired
    private TestExecutorAction action;
    @SpyBean
    private DataService service;

    @Test
    void test() {
        // Act
        action.execute();

        // Assert
        verify(service, timeout(1_100)).save("after 1 second");
    }
}