package com.MyQuizAppExpireQuizThread.thread;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuizExpirationThread implements Runnable {

	private static volatile boolean ifQuitFlag = false;
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public void run() {
		while (!ifQuitFlag) {
			restTemplate.delete("http://localhost:5000/deleteExpiredQuizs");
			try {
				Thread.sleep(1000 * 60 * 60 * 24);
			} catch (InterruptedException e) {
				// should log here!!!!
				System.out.println("exception in delete thread");
			}
		}
	}

	public static void endDeleteThread() {
		ifQuitFlag = true;
	}

	public static void changeDeleteThreadFlag(boolean flag) {
		ifQuitFlag = flag;
	}

	public static boolean getIfQuitFlag() {
		return ifQuitFlag;
	}
}
