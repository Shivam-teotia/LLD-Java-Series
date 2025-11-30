import entities.*;
import entities.vehicle.Bike;
import entities.vehicle.Car;
import entities.vehicle.Vehicle;
import enums.SpotSize;
import strategy.IFeeStrategy;
import strategy.IParkingStrategy;
import strategy.NearestSpotParkingStrategy;
import strategy.SimpleHourlyStrategy;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //create parking floor and spots
        List<ParkingFloor> floors=new ArrayList<>();
        for(int f=1;f<=3;f++){
            List<ParkingSpot> spots=new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                spots.add(new ParkingSpot("F" + f + "-B-" + i, f, SpotSize.BIKE));
            }
            // some compact spots
            for (int i = 1; i <= 20; i++) {
                spots.add(new ParkingSpot("F" + f + "-C-" + i, f, SpotSize.COMPACT));
            }
            // some large spots
            for (int i = 1; i <= 5; i++) {
                spots.add(new ParkingSpot("F" + f + "-L-" + i, f, SpotSize.LARGE));
            }
            floors.add(new ParkingFloor(f,spots));
        }

        //initialize parking lot singleton
        IParkingStrategy parkingStrategy=new NearestSpotParkingStrategy();
        IFeeStrategy feeStrategy = new SimpleHourlyStrategy(10,20,30);
        ParkingLot.init("My Mall Parking",floors, parkingStrategy,feeStrategy);

        EntryGate entryGate=new EntryGate(1,"Rahul");
        ExitGate exitGate=new ExitGate(2,"Neha");

        //Vehicle arrives
        Vehicle car=new Car("DL8CAF1234");
        Vehicle bike=new Bike("UP14AT5093");
        ParkingTicket ticket=entryGate.enter(car);
        ParkingTicket bikeTicket=entryGate.enter(bike);
        System.out.println("Ticket issued: " + ticket.getId()
                + " Spot: " + ticket.getSpot().getId());

        System.out.println("Ticket issued: " + bikeTicket.getId()
                + " Spot: " + bikeTicket.getSpot().getId());


        double fee = exitGate.exit(ticket.getId());
        System.out.println("Parking fee: " + fee);


        double feeBike = exitGate.exit(bikeTicket.getId());
        System.out.println("Parking fee: " + feeBike);
    }
}