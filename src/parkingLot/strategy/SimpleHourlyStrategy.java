package parkingLot.strategy;

import parkingLot.entities.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class SimpleHourlyStrategy implements IFeeStrategy{
    private final double bikeRatePerHour;
    private final double carRatePerHour;
    private final double truckRatePerHour;
    public SimpleHourlyStrategy(double bikeRatePerHour,
                                double carRatePerHour,
                                double truckRatePerHour) {
        this.bikeRatePerHour = bikeRatePerHour;
        this.carRatePerHour = carRatePerHour;
        this.truckRatePerHour = truckRatePerHour;
    }

    @Override
    public double calculateFee(ParkingTicket ticket) {
        LocalDateTime entry=ticket.getEntryTime();
        LocalDateTime exit= (ticket.getExitTime()!=null) ? ticket.getExitTime() : LocalDateTime.now();
        long minutes= Duration.between(entry,exit).toMinutes();
        long hours=Math.max(1,(long)Math.ceil(minutes/60.0));
        double rate;
        switch (ticket.getVehicle().getType()){
            case BIKE -> rate=bikeRatePerHour;
            case CAR -> rate=carRatePerHour;
            case TRUCK -> rate=truckRatePerHour;
            default -> throw new IllegalStateException("Unkown type");
        }
        return rate*hours;
    }
}
