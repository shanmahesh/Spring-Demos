package com.demographics;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(String s) {
        System.out.println("Received <" + s + ">");
    }
    
    
    @JmsListener(destination = "Myintegerbox", containerFactory = "myFactory")
    public void receiveMessage(Integer s) {
        System.out.println("Received <" + s + ">");
    }

}