package com.beady.elastic.observer;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailListener {
    private static final Logger logger= LoggerFactory.getLogger(EmailListener.class);
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    @Subscribe
    public void handler(NotifyEvent event){
        sendEmail(event.getTo(),event.getMessage(),event.getSubject());
        logger.info("send email to client:::" + event.getMessage());
    }
}
