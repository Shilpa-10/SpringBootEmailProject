
package com.abc.student.location.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component // this will tell that class is treated as a component and it will
//create object  at run time and we can inject this object into other classes.
public class EmailUtilImpl implements EmailUtil {

	@Autowired
	private JavaMailSender sender; // this is an interface of springand JavaMailSenderImpl automatically add
	//its implementation in it once it
	 // created.
	

	@Override
	public void sendEmail(String toAddress, String subject, String
  body) { 
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
		helper.setTo(toAddress);
		helper.setSubject(subject);
		helper.setText(body);
		}
		catch(MessagingException e) {
		e.printStackTrace();	
	}
		  sender.send(message);

  
  
  }
  
  }
