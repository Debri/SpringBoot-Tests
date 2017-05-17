package com.jms.service;

import com.jms.domain.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
@Component
public class Receiver {
    @JmsListener(destination = "mailBox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("received <" + email.toString() + ">");
    }
}
