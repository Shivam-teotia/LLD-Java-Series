package strategy;

import entities.ParkingTicket;

public interface IFeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
