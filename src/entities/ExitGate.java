package entities;

import entities.vehicle.Vehicle;

public class ExitGate extends Gate{
    public ExitGate(int id, String operatorName) {
        super(id, operatorName);
    }
    public double exit(String ticketId){
        ParkingLot lot=ParkingLot.getInstance();
        return lot.unparkVehicle(ticketId,this);
    }
}
