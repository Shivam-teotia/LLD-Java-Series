package parkingLot.strategy;

import parkingLot.entities.ParkingFloor;
import parkingLot.entities.ParkingSpot;
import parkingLot.entities.vehicle.Vehicle;

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
