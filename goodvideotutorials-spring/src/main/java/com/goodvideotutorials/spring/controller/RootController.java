package com.goodvideotutorials.spring.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodvideotutorials.spring.mail.MailSender;
import com.goodvideotutorials.spring.mail.MockMailSender;

@RestController
public class RootController {
	
	//@Resource
	private MailSender mailSender;
	
	@Autowired
	public RootController(@Qualifier("smtpMailSender") MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
	@RequestMapping("/")
	public String home() {
		
		mailSender.send("123@com", "Hello", "Hello Text");
		
		return "Hello world";
	}
}
