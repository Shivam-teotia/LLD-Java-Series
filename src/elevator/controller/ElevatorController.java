package elevator.controller;

import elevator.service.ElevatorService;

public class ElevatorController {
    private final ElevatorService elevatorService;

    public ElevatorController(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }

    public void step() {
        elevatorService.processNextRequest();
    }
}
