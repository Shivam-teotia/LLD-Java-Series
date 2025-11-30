package factory;

import entities.vehicle.Bike;
import entities.vehicle.Car;
import entities.vehicle.Truck;
import entities.vehicle.Vehicle;
import enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String plate){
        return switch (type){
            case BIKE -> new Bike(plate);
            case CAR -> new Car(plate);
            case TRUCK -> new Truck(plate);
        };
    }
}
