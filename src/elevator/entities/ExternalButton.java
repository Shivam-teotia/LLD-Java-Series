package elevator.entities;

import elevator.service.RequestService;
import elevator.enums.Direction;

public class ExternalButton extends Button {
    private final int floor;
    private final Direction direction;
    private final RequestService requestService;

    public ExternalButton(int floor, Direction direction, RequestService requestService) {
        this.floor = floor;
        this.direction = direction;
        this.requestService = requestService;
    }

    @Override
    public void press() {
        this.requestService.createExternalRequest(this.floor,this.direction);
    }
}
