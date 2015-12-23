package com.goodvideotutorials.spring.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockMailSender {
	private static final Logger logger = LoggerFactory.getLogger(MockMailSender.class);
	
	public void send(String to, String subject, String body) {
		logger.info("sending mail to " + to);
		logger.info("Subject: " + subject);
		logger.info("body: " + body);
	}
	
}
