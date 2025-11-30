package strategy;

import entities.ParkingFloor;
import entities.ParkingSpot;
import entities.vehicle.Vehicle;

import java.util.List;

public interface IParkingStrategy {
    ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
