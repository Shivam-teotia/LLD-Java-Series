package designPatterns.factory.service;

import designPatterns.factory.method.Notification;

public class SmsService implements Notification {
    public void send(){
        System.out.println("Sending with sms service");
    }
}
