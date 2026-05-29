package linkedin.entities;

import linkedin.enums.NotificationType;
import linkedin.observer.Subject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post extends Subject {
    private final String id;
    private final Member author;
    private final String content;
    private final LocalDateTime createdAt;
    private final List<Like> likes = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();

    public Post(Member member, String content, LocalDateTime createdAt) {
        this.id = UUID.randomUUID().toString();
        this.author = member;
        this.content = content;
        this.createdAt = createdAt;
        this.addObserver(member);
    }

    public void addLike(Member member) {
        this.likes.add(new Like(member));
        String notificationContent = member.getName() + " liked your post";
        Notification notification = new Notification(author.getId(), NotificationType.POST_LIKE, notificationContent);
        this.notifyObservers(notification);
    }

    public void addComment(Member member, String content) {
        this.comments.add(new Comment(member, content));
        String notificationContent = member.getName() + " commented your post";
        Notification notification = new Notification(author.getId(), NotificationType.POST_COMMENT, notificationContent);
        this.notifyObservers(notification);
    }

    public String getId() {
        return this.id;
    }

    public Member getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public List<Like> getLikes() {
        return this.likes;
    }

    public List<Comment> getComments() {
        return this.comments;
    }
}
