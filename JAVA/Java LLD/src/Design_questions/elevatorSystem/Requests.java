package Design_questions.elevatorSystem;

public class Requests {
    private int startFloor;
    private int destinationFloor;
    public Requests(int startFloor,int destinationFloor){
        this.startFloor=startFloor;
        this.destinationFloor=destinationFloor;

    }
    public int getStartFloor() {
        return startFloor;
    }
    public int getDestinationFloor() {
        return destinationFloor;
    }


}
