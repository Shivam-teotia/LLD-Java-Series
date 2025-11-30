package strategy;

import entities.ParkingFloor;
import entities.ParkingSpot;
import entities.vehicle.Vehicle;

import java.util.List;

public class NearestSpotParkingStrategy implements IParkingStrategy{
    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for(ParkingFloor floor: floors){
            List<ParkingSpot> free=floor.getFreeSpotsForVehicle(vehicle);
            if(!free.isEmpty()){
                return free.getFirst();
            }
        }
        return null;
    }
}
