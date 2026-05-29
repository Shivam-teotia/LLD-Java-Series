package linkedin.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private final String id;
    private final Member author;
    private final String text;
    private final LocalDateTime createdAt;

    public Comment(Member author, String text) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Member getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
