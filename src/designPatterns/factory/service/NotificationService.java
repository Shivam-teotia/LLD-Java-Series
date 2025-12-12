package designPatterns.factory.service;

import designPatterns.factory.method.Notification;
import designPatterns.factory.method.NotificationFactory;

public class NotificationService {
    public void sendNotification(String type){
        Notification notificationType = NotificationFactory.createNotification(type);
        notificationType.send();
    }
}
