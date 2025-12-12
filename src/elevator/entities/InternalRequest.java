package elevator.entities;

public class InternalRequest extends Request{
    private final int elevatorId;

    protected InternalRequest(int floor, final int id) {
        super(floor);
        this.elevatorId = id;
    }

    @Override
    public boolean IsExternal() {
        return false;
    }

    public int getElevatorId(){
        return this.elevatorId;
    }
}
