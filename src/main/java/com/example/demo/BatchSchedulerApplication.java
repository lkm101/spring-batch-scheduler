package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 추가
@SpringBootApplication
public class BatchSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchSchedulerApplication.class, args);
	}

}
