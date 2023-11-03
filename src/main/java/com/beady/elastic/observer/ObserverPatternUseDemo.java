package com.beady.elastic.observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ObserverPatternUseDemo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        EventCenter.register(new EmailListener());
        EventCenter.register(new SmsListener());
        EventCenter.post(new NotifyEvent("thank you letter"));

    }
}
