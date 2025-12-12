package designPatterns.factory.method;

import designPatterns.factory.service.EmailService;
import designPatterns.factory.service.SmsService;

public class NotificationFactory {
    public static Notification createNotification(String type){
        return switch (type){
            case "EMAIL" -> new EmailService();
            case "SMS" -> new SmsService();
            default -> throw new IllegalStateException("Unexpected value");
        };
    }
}
