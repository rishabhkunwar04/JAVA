package Design_questions.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class Levels {
    private int floor;
    private List<ParkingSpot> parkingspots;

     public Levels(int floor,int spotNumber){
         this.floor=floor;
         parkingspots=new ArrayList<>(spotNumber);

         //initiating spot for bike
         for(int i=1;i<spotNumber/2;i++){
             parkingspots.add(new ParkingSpot(i,VehicleType.Bike));
         }

         //initiating spot for car
         for(int i=spotNumber;i<=spotNumber;i++){
             parkingspots.add(new ParkingSpot(i,VehicleType.Car));
         }
     }
    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingspots) {
            if (spot.isAvilable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingspots) {
            if (!spot.isAvilable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.print("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingspots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvilable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }

}
