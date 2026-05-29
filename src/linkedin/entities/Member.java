package linkedin.entities;

import linkedin.observer.NotificationObserver;

import java.util.*;

public class Member implements NotificationObserver {
    private final String id;
    private final String name;
    private final String email;
    private final Profile profile;
    private final Set<Member> connections = new HashSet<Member>();
    private final List<Notification>  notifications = new ArrayList<Notification>();

    private Member(String email, String name, Profile profile) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.profile = profile;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Profile getProfile() { return profile; }
    public Set<Member> getConnections() { return connections; }
    public void addConnection(Member member) { connections.add(member); }

    public void displayProfile(){
        System.out.println("\n--- Profile for " + name + " (" + email + ") ---");
        profile.display();
        System.out.println("  Connections: " + connections.size());
    }

    public void viewNotifications() {
        System.out.println("--- Notifications for " + name + " (" + email + ") ---");
        if (notifications.isEmpty()) {
            System.out.println("  No new notifications");
            return;
        }
        notifications.stream().filter(Notification::isRead).forEach(notification -> {
            System.out.println("    - " + notification.getContent());
            notification.markAsRead();
        });
    }

    @Override
    public void update(Notification notification) {
        this.notifications.add(notification);
        System.out.printf("Notification pushed to %s: %s%n", this.name, notification.getContent());
    }

    public static class Builder {
        private String email;
        private String name;
        private String id;
        private Profile profile =  new Profile();

        public Builder(String name, String email) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.email = email;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        };

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder profile(Profile profile) {
            this.profile = profile;
            return this;
        }

        public Builder summary(String summary) {
            this.profile.setSummary(summary);
            return this;
        }

        public Builder addEducation(Education education) {
            this.profile.addEducation(education);
            return this;
        }

        public Builder addExperience(Experience experience) {
            this.profile.addExperience(experience);
            return this;
        }

        public Member build() {
            return new Member(email, name, profile);
        }
    }
}
