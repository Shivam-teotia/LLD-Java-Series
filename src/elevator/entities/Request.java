package elevator.entities;

public abstract class Request {
    protected final int floor;

    protected Request(int floor) {
        this.floor = floor;
    }

    public int getFloor(){
        return this.floor;
    }

    public abstract boolean IsExternal();
}
