package elevator.observer;

import elevator.enums.Direction;

public interface Observer {
    void update(int floor, Direction direction);
}
