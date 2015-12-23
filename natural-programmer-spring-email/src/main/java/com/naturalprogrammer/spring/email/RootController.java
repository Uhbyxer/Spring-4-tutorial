package com.naturalprogrammer.spring.email;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	@RequestMapping("/send-mail")
	public void sendMail()  {
		try {
			smtpMailSender.send("tgrynchuk@gmail.com", 
					"Test mail from Spring", "Hohoho !");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
