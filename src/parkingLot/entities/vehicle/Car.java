package parkingLot.entities.vehicle;

import parkingLot.enums.VehicleType;

public class Car extends Vehicle{
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
