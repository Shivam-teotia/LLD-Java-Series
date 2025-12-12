package elevator.entities;

import elevator.enums.Direction;

public class ExternalRequest extends Request{
    private final Direction direction;

    protected ExternalRequest(int floor, Direction direction) {
        super(floor);
        this.direction = direction;
    }

    @Override
    public boolean IsExternal() {
        return true;
    }

    public Direction getDirection(){
        return this.direction;
    }
}
