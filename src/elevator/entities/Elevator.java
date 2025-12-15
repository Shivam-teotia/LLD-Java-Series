package elevator.entities;

import elevator.enums.Direction;
import elevator.enums.ElevatorState;
import elevator.observer.Observer;
import elevator.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Elevator implements Subject {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private List<Observer> observers;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.observers = new ArrayList<>();
    }
    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveToFloor(int floor){
        this.direction = floor > currentFloor ? Direction.UP : Direction.DOWN;
        this.currentFloor = floor;
        notifyObserver();
        this.direction = Direction.IDLE;
    }

    @Override
    public void addObserver(Observer ob) {
        this.observers.add(ob);
    }

    @Override
    public void notifyObserver() {
        for(Observer ob: observers){
            ob.update(currentFloor, direction);
        }
    }
}
