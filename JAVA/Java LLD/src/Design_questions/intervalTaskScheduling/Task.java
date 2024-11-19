package Design_questions.intervalTaskScheduling;

public class Task {
    int startTime;
    int endTime;
    int priority;

    public Task(int startTime, int endTime, int priority) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", priority=" + priority +
                '}';
    }
}