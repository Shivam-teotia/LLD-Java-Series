package elevator.observer;

public interface Subject {
    void addObserver(Observer observer);
    void notifyObserver();
}
