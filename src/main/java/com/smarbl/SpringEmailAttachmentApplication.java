package com.smarbl;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailAttachmentApplication {
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailAttachmentApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailSenderService.sendMailWithAttachment("swati.wanjari@smarbl.com",
				"This is email body.",
				"This email subject", "" +
						"/home/swatiw/Downloads/sign.jpeg")
		;

	}
}
