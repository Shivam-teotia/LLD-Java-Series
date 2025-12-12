package elevator.entities;

import elevator.enums.Direction;
import elevator.enums.ElevatorState;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Elevator {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private final NavigableSet<Integer> upStops = new TreeSet<>();
    private final NavigableSet<Integer> downStops = new TreeSet<>();

    public Elevator(int id, int floor){
        this.id = id;
        this.currentFloor = floor;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.STOPPED;
    }

    public int getId() {
        return id;
    }

    public ElevatorState getState() {
        return state;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public NavigableSet<Integer> getUpStops() {
        return upStops;
    }

    public NavigableSet<Integer> getDownStops() {
        return downStops;
    }

    public void addDestination(int floor){
        if(floor>this.currentFloor){
            upStops.add(floor);
        }
        else if (floor == this.currentFloor){
            System.out.println("Already on same floor");
            return;
        }
        else {
            downStops.add(floor);
        }
    }

    public void externalDestination(int floor, Direction direction){
        if(direction == Direction.UP) upStops.add(floor);
        else if (direction == Direction.DOWN) downStops.add(floor);
    }

    public Integer nextStop(){
        if(direction == Direction.UP){
            Integer next= upStops.ceiling(this.currentFloor);
            if(next != null) return next;
            if(!downStops.isEmpty()){
                return downStops.last();
            }
            return null;
        }
        else if(direction == Direction.DOWN){
            Integer next = downStops.floor(this.currentFloor);
            if(next != null) return next;
            if (!upStops.isEmpty()){
                return upStops.first();
            }
            return null;
        }
        else { // NONE idle -> pick nearest
            Integer up = upStops.ceiling(currentFloor);
            Integer down = downStops.floor(currentFloor);
            if (up == null && down == null) return null;
            if (up == null) return down;
            if (down == null) return up;
            if (Math.abs(up - currentFloor) <= Math.abs(down - currentFloor)) return up;
            return down;
        }
    }
}
