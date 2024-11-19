package Design_questions.elevatorSystem;

public class Main {

    public static void main(String[] args) {
        ElevatorController elevatorController=new ElevatorController(3,10);

        elevatorController.requestElevator(1,3);
        elevatorController.requestElevator(4,1);

    }
}
