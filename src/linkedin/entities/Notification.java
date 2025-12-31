package linkedin.entities;

import linkedin.enums.NotificationType;

import java.time.LocalDate;
import java.util.UUID;

public class Notification {
    private final String id;
    private final String content;
    private final LocalDate createdAt = LocalDate.now();
    private boolean isRead = false;

    public Notification(String memberId, String content, NotificationType notificationType) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void markAsRead() { this.isRead = true; }
    public boolean isRead() { return isRead; }
}
