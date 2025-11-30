package entities;

import entities.vehicle.Vehicle;

public class EntryGate extends Gate{
    public EntryGate(int id, String operatorName) {
        super(id, operatorName);
    }
    public ParkingTicket enter(Vehicle vehicle){
        ParkingLot lot=ParkingLot.getInstance();
        return lot.parkVehicle(vehicle,this);
    }
}
