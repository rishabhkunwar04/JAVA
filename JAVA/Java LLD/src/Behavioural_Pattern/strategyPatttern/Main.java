package Behavioural_Pattern.strategyPatttern;

public class Main {
    public static void main(String[] args) {
        Vehicle royalsRoyse=new LuxuryVehicle(new LuxuryDrive());
        royalsRoyse.drive();
        Vehicle buggati=new SportsVehicle(new LuxuryDrive());
        buggati.drive();
        Vehicle swiftDezire=new NormalVehicle(new NormalDrive());
        swiftDezire.drive();
    }
}
