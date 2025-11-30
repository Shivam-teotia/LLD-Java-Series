package parkingLot.entities.vehicle;

import parkingLot.enums.VehicleType;

public class Bike extends Vehicle{
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}
