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
	
	 public String sendEmail(float price,String to) {
		 String from = "samarthshetty13@gmail.com";
//		 String to = "samarthshetty13@gmail.com";
		  
		 SimpleMailMessage message = new SimpleMailMessage();
		  
		 message.setFrom(from);
		 message.setTo(to);
		 message.setSubject("This is invoice of food order");
		 message.setText("final Amount of your order is:"+ price);
		  
		 mailSender.send(message);
		 
		 return "Email sent";
	    }

}
