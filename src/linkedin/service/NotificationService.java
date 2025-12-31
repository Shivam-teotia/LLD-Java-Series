package linkedin.service;

import linkedin.entities.Member;
import linkedin.entities.Notification;

public class NotificationService {
    public void sendNotification(Member member, Notification notification){
        member.update(notification);
    }
}
