package linkedin.observer;

import linkedin.entities.Notification;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<NotificationObserver> observers = new ArrayList<NotificationObserver>();

    public void addObserver(NotificationObserver  observer) {
        this.observers.add(observer);
    }

    public void removeObserver(NotificationObserver  observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(Notification notification) {
        for (NotificationObserver observer : observers) {
            observer.update(notification);
        }
    }
}
