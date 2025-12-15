package elevator.algorithm;

import elevator.entities.Request;

import java.util.List;

public interface SchedulingStrategy {
    Request selectextRequest(List<Request> requests);
}
