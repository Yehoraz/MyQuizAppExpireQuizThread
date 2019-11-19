package com.MyQuizAppExpireQuizThread.thread;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@PropertySource(value = "classpath:info.properties")
public class QuizExpirationScheduled {

	@Autowired
	private Environment env;

	private RestTemplate restTemplate;
	private String url;

	@PostConstruct
	private void urlSet() {
		restTemplate = new RestTemplate();
		url = env.getProperty("url.mainAppExpiredRequestURL");
	}

	@Scheduled(fixedRate = (1000 * 60 * 60 * 24))
	private void task() {
		restTemplate.delete(url);
	}

}
