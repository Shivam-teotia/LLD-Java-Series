package elevator.service;

import elevator.entities.Request;
import elevator.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class RequestService {
    private final List<Request> requests = new ArrayList<>();

    public List<Request> getRequests() {
        return requests;
    }

    public void createInternalRequest(int destinationFloor){
        this.requests.add(new Request(-1, destinationFloor));
    }

    public void createExternalRequest(int floor, Direction direction){
        int destination = direction == Direction.UP ? floor + 1 : floor - 1;
        this.requests.add(new Request(floor,destination));
    }
}
