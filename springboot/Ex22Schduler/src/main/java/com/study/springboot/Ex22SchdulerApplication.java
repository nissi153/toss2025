package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Ex22SchdulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex22SchdulerApplication.class, args);
	}

}
