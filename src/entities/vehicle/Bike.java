package entities.vehicle;

import enums.VehicleType;

public class Bike extends Vehicle{
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}
