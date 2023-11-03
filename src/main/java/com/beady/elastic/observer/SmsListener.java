package com.beady.elastic.observer;

import com.google.common.eventbus.Subscribe;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import com.twilio.type.PhoneNumber;

public class SmsListener {
    private static  final Logger logger=LoggerFactory.getLogger(SmsListener.class);
    @Value("${twilio.accountSid}")
    private String twilioAccountSid;

    @Value("${twilio.authToken}")
    private String twilioAuthToken;

    @Subscribe
    public void handler(NotifyEvent event){
        logger.info("send sms to client:::"+event.getMessage());
        Twilio.init(twilioAccountSid, twilioAuthToken);
        Message message = Message.creator(
                new PhoneNumber("recipient_phone_number"),
                new PhoneNumber("your_twilio_phone_number"),
                event.getMessage()
        ).create();
        logger.info("send sms to client:::"+message.getSid());


    }
}
