package parkingLot.strategy;

import parkingLot.entities.ParkingTicket;

public interface IFeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
