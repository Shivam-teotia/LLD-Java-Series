package parkingLot.factory;

import parkingLot.entities.vehicle.Bike;
import parkingLot.entities.vehicle.Car;
import parkingLot.entities.vehicle.Truck;
import parkingLot.entities.vehicle.Vehicle;
import parkingLot.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String plate){
        return switch (type){
            case BIKE -> new Bike(plate);
            case CAR -> new Car(plate);
            case TRUCK -> new Truck(plate);
        };
    }
}
