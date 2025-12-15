package elevator.service;

import elevator.algorithm.SchedulingStrategy;
import elevator.entities.Elevator;
import elevator.entities.Request;

public class ElevatorService {
    private final Elevator elevator;
    private final RequestService requestService;
    private SchedulingStrategy schedulingStrategy;

    public ElevatorService(Elevator elevator, RequestService requestService, SchedulingStrategy schedulingStrategy) {
        this.elevator = elevator;
        this.requestService = requestService;
        this.schedulingStrategy = schedulingStrategy;
    }

    public void processNextRequest(){
        Request request = schedulingStrategy.selectextRequest(requestService.getRequests());
        if (request!=null){
            elevator.moveToFloor(request.getDestinationFloor());
        }
    }
}
