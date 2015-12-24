package com.naturalprogrammer.spring.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	
//	static
//	{
//	     System.setProperty("mail.smtp.auth", "true");
//	     System.setProperty("mail.smtp.socketFactory.port", "465");
//	     System.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//	     System.setProperty("mail.smtp.socketFactory.fallback", "false");
//	     System.setProperty("mail.smtp.user","noreply.log4jrobot@gmail.com");
//	     System.setProperty("mail.smtp.starttls.enable","true");
//	     System.setProperty("mail.transport.protocol", "smtp");
//	     System.setProperty("mail.smtp.starttls.enable", "true");
//	     System.setProperty("mail.smtp.host", "smtp.gmail.com");
//	     System.setProperty("mail.smtp.port", "465");
//	     System.setProperty("mail.smtp.quitwait", "false");
//	}
	
	@Autowired
	private JavaMailSender javaMailSender; 
	
	public void send(String to, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);
		
		javaMailSender.send(message);
	}
}
