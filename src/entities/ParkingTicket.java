package entities;

import entities.vehicle.Vehicle;
import enums.TicketStatus;

import java.time.LocalDateTime;

public class ParkingTicket {
    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;
    private TicketStatus status;

    public ParkingTicket(String id, Vehicle vehicle, ParkingSpot spot, LocalDateTime entryTime) {
        this.id = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
    }

    public String getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public double getAmount() { return amount; }
    public TicketStatus getStatus() { return status; }

    public void close(LocalDateTime exitTime, double amount) {
        this.exitTime = exitTime;
        this.amount = amount;
        this.status = TicketStatus.PAID;
    }
}
