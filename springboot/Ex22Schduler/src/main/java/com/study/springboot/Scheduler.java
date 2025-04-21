package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Slf4j
@EnableAsync //비동기적으로 처리하도록 제공하는 스프링 어노테이션
             //각기 다른 쓰레드에서 실행된다.
public class Scheduler {


//    @Scheduled(fixedRate = 1000) //1초마다 주기적 실행
//    public void task1(){
//        //currentTimeMillis() : time stamp - 1970.00.00.00.00부터 시작된 밀리초
//        //log.info("FixedRate task1 - {}", System.currentTimeMillis()/1000);
//        log.info("FixedRate task1 - {}", LocalTime.now());
//    }
    @Scheduled(fixedRate = 1000)
    public void task2() throws InterruptedException {
        log.info("FixedRate task2 - {}", LocalTime.now());
        Thread.sleep( 5000 ); //5초동안 멈춤.
        log.info("dead!");
    }
    @Async
    @Scheduled(fixedRate = 1000, initialDelay = 5000)
    public void task3() throws InterruptedException{
        log.info("FixedRate task3 - {}", LocalTime.now());
        Thread.sleep( 5000 ); //5초동안 멈춤.
        log.info("dead!");
    }

}










