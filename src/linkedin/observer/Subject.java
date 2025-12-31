package linkedin.observer;

import linkedin.entities.Notification;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    public final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer){
        this.observers.remove(observer);
    }
    
    public void notifyObserver(Notification notification){
        for (NotificationObserver observer : this.observers) {
            observer.update(notification);
        }
    }
}
