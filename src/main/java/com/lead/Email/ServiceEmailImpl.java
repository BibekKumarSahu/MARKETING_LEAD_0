package com.lead.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ServiceEmailImpl implements ServiceEmail {
	@Autowired
	JavaMailSender javamailsender;

	@Override
	public void emailsend(String To, String sub, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(To);
		message.setSubject(sub);
		message.setText(msg);
		javamailsender.send(message);
	}

}
