package designPatterns.factory.service;

import designPatterns.factory.method.Notification;

public class EmailService implements Notification {
    public void send(){
        System.out.println("Sending with email service");
    }
}
