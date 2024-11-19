package Design_questions.elevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevatorList;

    public ElevatorController(int noOfElevator,int capacity){
        this.elevatorList=new ArrayList<>();
        for(int i=0;i<noOfElevator;i++){
            Elevator elevator=new Elevator(i+1,capacity);
            elevatorList.add(elevator);
            new Thread(elevator::run).start();
        }

    }
   public  void requestElevator(int startFloor,int destinationFloor){
        Elevator optimalElevator=findOptimalElevator(startFloor,destinationFloor);
        optimalElevator.addRequest(new Requests(startFloor,destinationFloor));

   }

   //find optimalElevator to process Request
    public Elevator findOptimalElevator(int startFloor,int destinationFloor){
        Elevator optimal=null;
        int minDistance=Integer.MAX_VALUE;
        for(Elevator  elevator: elevatorList){
            int distance = Math.abs(startFloor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                optimal = elevator;
            }
        }
       return optimal;
    }


}
