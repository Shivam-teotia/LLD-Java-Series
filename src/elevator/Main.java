package elevator;

import elevator.algorithm.SimpleFCSStrategy;
import elevator.controller.ElevatorController;
import elevator.entities.Elevator;
import elevator.enums.Direction;
import elevator.observer.DisplayBoard;
import elevator.service.ElevatorService;
import elevator.service.RequestService;

public class Main {
    public static void main(String[] args){
        // ===== Create Elevators =====
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);

        elevator1.addObserver(new DisplayBoard());
        elevator2.addObserver(new DisplayBoard());

        // ===== Shared Request Service =====
        RequestService requestService = new RequestService();

        // ===== Elevator Services =====
        ElevatorService elevatorService1 =
                new ElevatorService(elevator1, requestService, new SimpleFCSStrategy());

        ElevatorService elevatorService2 =
                new ElevatorService(elevator2, requestService, new SimpleFCSStrategy());

        // ===== Controllers =====
        ElevatorController controller1 = new ElevatorController(elevatorService1);
        ElevatorController controller2 = new ElevatorController(elevatorService2);

        // ===== External Requests =====
        requestService.createExternalRequest(0, Direction.UP);
        requestService.createExternalRequest(3, Direction.DOWN);
        requestService.createExternalRequest(5, Direction.UP);

        // ===== Internal Requests =====
        requestService.createInternalRequest(7);
        requestService.createInternalRequest(2);
        requestService.createInternalRequest(9);

        // ===== Simulate Steps =====
        System.out.println("---- Step 1 ----");
        controller1.step();
        controller2.step();

        System.out.println("---- Step 2 ----");
        controller1.step();
        controller2.step();

        System.out.println("---- Step 3 ----");
        controller1.step();
        controller2.step();

        System.out.println("---- Step 4 ----");
        controller1.step();
        controller2.step();
    }
}
