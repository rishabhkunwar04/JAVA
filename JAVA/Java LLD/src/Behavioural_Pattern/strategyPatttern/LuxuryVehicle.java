package Behavioural_Pattern.strategyPatttern;

public class LuxuryVehicle  extends Vehicle{
    public LuxuryVehicle(Drive driveCapability) {
        super(driveCapability);
    }

    @Override
    public void drive() {
        super.drive();
    }
}
