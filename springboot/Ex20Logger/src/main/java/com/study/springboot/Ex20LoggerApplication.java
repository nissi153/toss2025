package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Ex20LoggerApplication {

	public static void main(String[] args) {
		log.info("test...");
		SpringApplication.run(Ex20LoggerApplication.class, args);
	}

}
