package Design_questions.taskManagmentSystem;

import java.sql.Date;

public class Task {
    private String taskId;
    private String title;
    private String description;
    private String status; // Pending, In Progress, Completed
    private int priority;
    private Date dueDate;
    private User assignedUser;
    private Date reminderDate;

    public Task(String taskId, String title, String description, User assignedUser, Date dueDate, int priority) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = "Pending";
        this.priority = priority;
        this.dueDate = dueDate;
        this.assignedUser = assignedUser;
    }

    public String getTaskId() { return taskId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getPriority() { return priority; }
    public Date getDueDate() { return dueDate; }
    public User getAssignedUser() { return assignedUser; }
    public void setAssignedUser(User assignedUser) { this.assignedUser = assignedUser; }
    public Date getReminderDate() { return reminderDate; }
    public void setReminderDate(Date reminderDate) { this.reminderDate = reminderDate; }
}
