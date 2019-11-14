package com.MyQuizAppExpireQuizThread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyQuizAppExpireQuizThread.thread.QuizExpirationThread;

@SpringBootApplication
@RestController
public class MyQuizAppExpireQuizThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyQuizAppExpireQuizThreadApplication.class, args);
		
		startDeleteThread();
	}
	
	public static void startDeleteThread() {
		Thread t1 = new Thread(new QuizExpirationThread());
		t1.start();
	}
	
	@PutMapping("/restartDeleteThread")
	public void restartDeleteThread(){
		if(QuizExpirationThread.getIfQuitFlag() == true) {
			startDeleteThread();
		}
	}
	
	@PutMapping("endDeleteThread")
	public void endDeleteThread(){
		QuizExpirationThread.endDeleteThread();
	}

}
