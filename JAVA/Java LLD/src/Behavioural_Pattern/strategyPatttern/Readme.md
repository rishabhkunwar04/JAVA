## Strategy Pattern
``` java


//strategy class
public interface Drive {
    public void drive();
}

public class LuxuryDrive  implements Drive{
    @Override
    public void drive() {
        System.out.println("Luxury drive facility");
    }
}

public class NormalDrive implements Drive{
    @Override
    public void drive() {
        System.out.println("Normal drive facility");
    }
}




//context class
public class Vehicle {
    Drive driveCapability;
    public Vehicle(Drive driveCapability){
        this.driveCapability=driveCapability;
    }
    public void drive(){
        driveCapability.drive();
    }
}

public class SportsVehicle extends Vehicle {
    public SportsVehicle(Drive driveCapability) {
        super(driveCapability);
    }

    @Override
    public void drive() {
        super.drive();
    }
}

public class NormalVehicle  extends Vehicle{
    public NormalVehicle(Drive driveCapability) {
        super(driveCapability);
    }

    @Override
    public void drive() {
        super.drive();
    }
}
public class LuxuryVehicle  extends Vehicle{
    public LuxuryVehicle(Drive driveCapability) {
        super(driveCapability);
    }

    @Override
    public void drive() {
        super.drive();
    }
}




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

```