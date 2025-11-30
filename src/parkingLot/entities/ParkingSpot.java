package parkingLot.entities;

import parkingLot.entities.vehicle.Vehicle;
import parkingLot.enums.SpotSize;

public class ParkingSpot {
    private final String id;
    private boolean isFree;
    private final int floorNumber;
    private final SpotSize spotType;
    private Vehicle vehicle;

    public ParkingSpot(String id, int floorNumber, SpotSize spotSize) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.spotType = spotSize;
        this.isFree = true;
        this.vehicle = null;
    }

    public String getId() { return id; }
    public int getFloorNumber() { return floorNumber; }
    public SpotSize getSpotType() { return spotType; }
    public Vehicle getParkedVehicle() { return vehicle; }

    public boolean canFitVehicle(Vehicle vehicle) {
        return switch (vehicle.getType()) {
            case BIKE -> true; // bike can go anywhere
            case CAR -> (spotType == SpotSize.COMPACT || spotType == SpotSize.LARGE);
            case TRUCK -> (spotType == SpotSize.LARGE);
        };
    }

    public synchronized boolean isFree(){
        return this.isFree;
    }

    public void park(Vehicle vehicle){
        if(!isFree || !canFitVehicle(vehicle)){
            throw new IllegalStateException("Spot not available");
        }
        this.vehicle=vehicle;
        this.isFree=false;
    }

    public void vacate(){
        this.vehicle=null;
        this.isFree=true;
    }
}
