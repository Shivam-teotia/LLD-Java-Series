package elevator.algorithm;

import elevator.entities.Request;

import java.util.List;

public class SimpleFCSStrategy implements SchedulingStrategy{
    @Override
    public Request selectextRequest(List<Request> requests) {
        if (!requests.isEmpty()){
            return requests.removeFirst();
        }
        return null;
    }
}
