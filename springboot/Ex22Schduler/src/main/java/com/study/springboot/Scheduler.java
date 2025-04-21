package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.SimpleFormatter;

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
//    @Scheduled(fixedRate = 1000, initialDelay = 5000)
//    public void task2() throws InterruptedException {
//        log.info("FixedRate task2 - {}", LocalTime.now());
//        Thread.sleep( 5000 ); //5초동안 멈춤.
//        log.info("dead!");
//    }
//    static int threadId = 0;
//    @Async  //비동기적으로 스레드(task) 동작하도록
//    @Scheduled(fixedRate = 1000)
//    public void task3() throws InterruptedException{
//        log.info("FixedRate task3 {} - {}", threadId, LocalTime.now());
//        Thread.sleep( 2000 ); //2초동안 멈춤.
//        log.info("dead! {}", threadId++);
//    }
    //Cron 표현식
    //초(0~59) 분(0~59) 시간(0~23) 일(1~31) 월(1~12) 요일(0~6)
    //spring에서는 리눅스cron과 달리 연도 설도 설정은 할 수 없다.
    //                0초 15분 10시 15일 매달 알수없는요일
    //@Scheduled(cron = "0 28 10 21 * ?")
    //@Scheduled(cron = "* * * * * *")
    @Scheduled(cron = "0 45 11 * * *")
    public void task4(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdf.format( now );
        log.info("cron task - {}", strDate);
    }
    @Autowired
    RestTemplate restTemplate;
    @Scheduled(fixedRate = 5000)
    public void task5(){
        log.info("task5 - {}", LocalTime.now());

        String url = "http://localhost:8080/api/batch-job";
        ResponseEntity response =
                restTemplate.getForEntity(url, String.class);
        log.info((String) response.getBody());

    }

}










