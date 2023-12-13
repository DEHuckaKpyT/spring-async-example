package com.example.lesson8.action;

import com.example.lesson8.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@SpringBootTest
public class CallerActionIT {

    @Autowired
    private CallerAction action;
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
