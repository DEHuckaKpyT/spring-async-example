package com.example.lesson8.config;

import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created on 13.12.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@EnableAsync
@EnableScheduling
@Configuration
public class AsyncConfig {

    @Bean("testExecutor")
    public Executor testExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(100); // максимальное количество потоков, которые могут быть когда-либо созданы
        executor.setCorePoolSize(10); // минимальное количество рабочих процессов, которое необходимо поддерживать
        executor.setThreadNamePrefix("testExecutor-");
        executor.initialize();
        return executor;
    }

    /**
     * Нужно, чтобы при добавлении своих кастомных executor'ов также создавался и executor по-умолчанию
     * <a href="https://stackoverflow.com/questions/54093777/how-to-create-additional-taskexecutor-beside-taskexecutionautoconfiguration">stackoverflow</a>
     */
    @Lazy
    @Bean(name = {TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME,
            AsyncAnnotationBeanPostProcessor.DEFAULT_TASK_EXECUTOR_BEAN_NAME})
    public ThreadPoolTaskExecutor applicationTaskExecutor(TaskExecutorBuilder builder) {
        return builder.build();
    }
}
