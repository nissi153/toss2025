package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogTest extends Ex20LoggerApplicationTests {
    static int count = 0;
    @Test
    public void testSlf4j(){
        log.trace("slf4j trace 로깅 {}", count++);
        log.debug("slf4j debug 로깅 {}", count++);
        log.info("slf4j info 로깅 {}", count++);
        log.warn("slf4j warn 로깅 {}", count++);
        log.error("slf4j error 로깅 {}", count++);
    }

    @Test
    public void TestLogger(){
        Class myClass = LogTest.class;
        //class객체는 클래스에 대한 모든 정보(멤버함수,필드,어노테이션,생성자)
        //담고 있다.

        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.trace("trace 로깅 {}", count++);
        logger.debug("debug 로깅 {}", count++);
        logger.info("info 로깅 {}", count++);
        logger.warn("warn 로깅 {}", count++);
        logger.error("error 로깅 {}", count++);

    }
}
