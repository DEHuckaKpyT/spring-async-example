package com.example.lesson8.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@Slf4j
@Service
public class DataService {

    public void save(String name) {
        log.info(name);
    }
}
