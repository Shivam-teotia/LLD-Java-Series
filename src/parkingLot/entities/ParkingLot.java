package parkingLot.entities;

import parkingLot.entities.vehicle.Vehicle;
import parkingLot.strategy.IFeeStrategy;
import parkingLot.strategy.IParkingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private static volatile ParkingLot INSTANCE;
    private final String name;
    private final List<ParkingFloor> floors;
    private IParkingStrategy parkingStrategy;
    private IFeeStrategy feeStrategy;
    private Map<String,ParkingTicket> activeTickets;

    public ParkingLot(String name, List<ParkingFloor> floors, IParkingStrategy parkingStrategy, IFeeStrategy feeStrategy) {
        this.name = name;
        this.floors = floors;
        this.parkingStrategy = parkingStrategy;
        this.feeStrategy = feeStrategy;
        this.activeTickets = new HashMap<>();
    }

    public static ParkingLot getInstance(){
        if(INSTANCE==null){
            synchronized (ParkingLot.class){
                if(INSTANCE==null){
                    throw new IllegalStateException("Parking not initialized");
                }
            }
        }
        return INSTANCE;
    }

    public static void init(String name, List<ParkingFloor> floors, IParkingStrategy parkingStrategy, IFeeStrategy feeStrategy){
        if (INSTANCE!=null){
            throw new IllegalStateException("ParkingLot already initialised");
        }
        synchronized (ParkingLot.class){
            if (INSTANCE==null){
                INSTANCE = new ParkingLot(name,floors,parkingStrategy,feeStrategy);
            }
        }
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle,EntryGate gate){
        ParkingSpot spot=parkingStrategy.findSpot(floors,vehicle);
        if (spot==null){
            throw new IllegalStateException("No parking spot available");
        }
        spot.park(vehicle);
        String ticketId= UUID.randomUUID().toString();
        ParkingTicket parkingTicket=new ParkingTicket(ticketId,vehicle,spot, LocalDateTime.now());
        activeTickets.put(ticketId,parkingTicket);
        return parkingTicket;
    }
    public synchronized double unparkVehicle(String ticketId, ExitGate gate) {
        ParkingTicket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket");
        }
        ParkingSpot spot = ticket.getSpot();

        // Set exit time
        LocalDateTime exitTime = LocalDateTime.now();
        double fee = feeStrategy.calculateFee(ticket);
        ticket.close(exitTime, fee);

        spot.vacate();
        activeTickets.remove(ticketId);
        return fee;
    }

    public String getName(){
        return this.name;
    }

    public void setParkingStrategy(IParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
    }

    public void setFeeStrategy(IFeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }
}
