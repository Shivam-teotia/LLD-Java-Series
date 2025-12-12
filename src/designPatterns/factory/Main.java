package designPatterns.factory;

import designPatterns.factory.service.NotificationService;

public class Main {
    public static void main(String[] args){
        NotificationService service = new NotificationService();
        service.sendNotification("EMAIL");
    }
}
