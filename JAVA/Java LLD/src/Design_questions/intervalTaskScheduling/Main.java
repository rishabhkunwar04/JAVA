package Design_questions.intervalTaskScheduling;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3, 50));
        tasks.add(new Task(2, 5, 20));
        tasks.add(new Task(3, 10, 100));
        tasks.add(new Task(6, 19, 200));
        tasks.add(new Task(8, 20, 150));

        Scheduler scheduler = new Scheduler();
        List<Task> optimalSchedule = scheduler.getMaxPrioritySchedule(tasks);

        System.out.println("Optimal Task Schedule:");
        for (Task task : optimalSchedule) {
            System.out.println(task);
        }

        int maxPriority = optimalSchedule.stream().mapToInt(task -> task.priority).sum();
        System.out.println("Maximum Combined Priority: " + maxPriority);
    }
}
