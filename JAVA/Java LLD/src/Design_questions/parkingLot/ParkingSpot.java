package Design_questions.parkingLot;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedvehicle;

    public ParkingSpot(int spotNumber,VehicleType vehicleType){
        this.spotNumber=spotNumber;
        this.vehicleType=vehicleType;

    }
    //parkvehicle
    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvilable() && vehicle.getType() == vehicleType) {
            parkedvehicle = vehicle;
        } else {
            throw new IllegalArgumentException("incorrect vehicle type or parking spot is not avilable");
        }
    }
    //unpark vehicle
    public synchronized void unparkVehicle() {
        parkedvehicle = null;
    }


    // getspotNumber
      public  synchronized  int getSpotNumber(){
        return spotNumber;
      }

    //getvehicletype
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedvehicle;
    }

    //isAvilable
    public synchronized boolean  isAvilable(){
        return parkedvehicle==null;
    }

}
