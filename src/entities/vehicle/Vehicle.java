package entities.vehicle;

import enums.VehicleType;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    protected Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate(){
        return this.licensePlate;
    }

    public VehicleType getType(){
        return this.type;
    }
}
