package elevator.entities;

import elevator.service.RequestService;

public class InternalButton extends Button{
    private final int floor;
    private final RequestService requestService;

    public InternalButton(int floor, RequestService requestService) {
        this.floor = floor;
        this.requestService = requestService;
    }

    @Override
    public void press() {
        this.requestService.createInternalRequest(floor);
    }
}
