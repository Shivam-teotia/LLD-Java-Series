package designPatterns.observerDesign;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    private int temperature;
    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer ob) {
        this.observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        this.observers.remove(ob);
    }

    @Override
    public void notifyObserver() {
        for(Observer ob : observers){
            ob.update();
        }
    }

    //Business logic
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObserver();  // IMPORTANT
    }
}
