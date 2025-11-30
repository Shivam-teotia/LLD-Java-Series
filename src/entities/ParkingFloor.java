package entities;

import entities.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public int getFloorNumber(){
        return this.floorNumber;
    }

    public List<ParkingSpot> getAllSpots(){
        return this.spots;
    }

    public List<ParkingSpot> getFreeSpotsForVehicle(Vehicle vehicle){
        List<ParkingSpot> free=new ArrayList<>();
        for(ParkingSpot spot:spots){
            if(spot.isFree() && spot.canFitVehicle(vehicle)){
                free.add(spot);
            }
        }
        return free;
    }
}
