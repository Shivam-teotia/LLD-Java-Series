package elevator.observer;

import elevator.enums.Direction;

public class DisplayBoard implements Observer{

    @Override
    public void update(int floor, Direction direction) {
        System.out.println("DisplayBoard Floor :-> " +floor+" Direction :-> " +direction);
    }
}
