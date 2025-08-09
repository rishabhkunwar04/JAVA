package Design_questions.taskManagmentSystem;

import java.sql.Date;

public class Task {
    private String taskId;
    private String description;
    private String status; // e.g., "Pending", "In Progress", "Completed"
    private int priority;
    private Date dueDate;

    public Task(String taskId, String description, User assignedUser, Date dueDate, int priority) {
        this.taskId = taskId;
        this.description = description;
        this.status = "Pending";
        this.priority= priority;
        this.dueDate = dueDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
