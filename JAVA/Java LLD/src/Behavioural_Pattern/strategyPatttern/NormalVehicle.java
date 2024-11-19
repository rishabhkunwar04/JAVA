package Behavioural_Pattern.strategyPatttern;

public class NormalVehicle  extends Vehicle{
    public NormalVehicle(Drive driveCapability) {
        super(driveCapability);
    }

    @Override
    public void drive() {
        super.drive();
    }
}
