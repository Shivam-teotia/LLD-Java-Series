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

        //observer
        this.observers.add(this.author);
    }

    public void addLike(Member member) {
        likes.add(new Like(member));
        String notificationContent = member.getName() + " liked your post.";
        Notification notification = new Notification(author.getId(),notificationContent, NotificationType.POST_LIKE);
        notifyObserver(notification);
    }

    public void addComment(Member member, String text) {
        comments.add(new Comment(member, text));
        String notificationContent = member.getName() + " commented on your post: \"" + text + "\"";
        Notification notification = new Notification(author.getId(),notificationContent, NotificationType.POST_COMMENT);
        notifyObserver(notification);
    }

    public String getId() { return id; }
    public Member getAuthor() { return author; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<Like> getLikes() { return likes; }
    public List<Comment> getComments() { return comments; }


}
