package Behavioural_Pattern.strategyPatttern;

public class NormalDrive implements Drive{
    @Override
    public void drive() {
        System.out.println("Normal drive facility");
    }
}
