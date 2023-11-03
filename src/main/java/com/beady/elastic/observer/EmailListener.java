package com.beady.elastic.observer;

import com.google.common.eventbus.Subscribe;

public class EmailListener {
    @Subscribe
    public void handler(NotifyEvent event){
        System.out.println("send email to client:::"+event.getMessage());
    }
}
