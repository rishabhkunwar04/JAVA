package Design_questions.parkingLot;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkinglot =ParkingLot.getInstance();

        parkinglot.addLevel(new Levels(1,2));
        parkinglot.addLevel(new Levels(2,2));

        Vehicle car=new Car("RK-12345");
        Vehicle  bike=new Bike("BR-9708");


        //parkvehicle
        parkinglot.parkVehicle(car);
        parkinglot.parkVehicle(bike);
        parkinglot.displayAvailability();



    }
}
