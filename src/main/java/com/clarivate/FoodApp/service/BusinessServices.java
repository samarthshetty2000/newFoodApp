package com.clarivate.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class BusinessServices{

	@Autowired
    private JavaMailSender mailSender;
	
	 public void sendEmail() {
		 String from = "samarthshetty13@gmail.com";
		 String to = "samarthshetty13@gmail.com";
		  
		 SimpleMailMessage message = new SimpleMailMessage();
		  
		 message.setFrom(from);
		 message.setTo(to);
		 message.setSubject("This is a plain text email");
		 message.setText("Hello guys! This is a plain text email.");
		  
		 mailSender.send(message);
	    }

}
