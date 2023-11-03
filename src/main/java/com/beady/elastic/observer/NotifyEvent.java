package com.beady.elastic.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyEvent {
    private String message;
    private String from;
    private String to;
    private String subject;
}
