package com.bakhromjonov.springbootsendemail;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootSendEmailApplication {

    private final EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSendEmailApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerEmail() throws MessagingException {
        emailSenderService.sendMailWithAttachment("isaaabdukhalilov@gmail.com",
                "This is body, my boy",
                "This is email with attachment",
                "/Users/macbook/Downloads/resume.pdf");
    }

}
