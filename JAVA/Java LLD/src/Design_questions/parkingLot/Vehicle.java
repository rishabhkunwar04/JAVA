package Design_questions.parkingLot;

public  abstract class Vehicle {
    protected String VechNum;
    protected VehicleType type;

    public Vehicle(String VechNum,VehicleType type){
        this.VechNum=VechNum;
        this.type=type;
    }
    public VehicleType getType(){
        return this.type;
    }
}
