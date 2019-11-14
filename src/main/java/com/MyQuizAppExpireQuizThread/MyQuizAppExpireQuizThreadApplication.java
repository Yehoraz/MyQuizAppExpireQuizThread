package com.MyQuizAppExpireQuizThread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@SpringBootApplication
@RestController
public class MyQuizAppExpireQuizThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyQuizAppExpireQuizThreadApplication.class, args);
		}

}
