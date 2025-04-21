package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Slf4j
@Configuration //Config클래스에서 외부라이러리에 대한 설정을 한다.
public class SchedulerConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //Thread Pool 설정
        ThreadPoolTaskScheduler threadPool =
           new ThreadPoolTaskScheduler();

        //Thread 개수 설정
        int n = Runtime.getRuntime().availableProcessors(); //CPU의 코어갯수
        log.info("core 갯수 - {}", n);
        threadPool.setPoolSize( n );
        threadPool.initialize();

        taskRegistrar.setScheduler(threadPool);
    }
}
