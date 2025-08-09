package Design_questions.taskManagmentSystem;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    private final List<Task> taskList;
    private final List<Task> taskHistory;

    public TaskService() {
        this.taskList = Collections.synchronizedList(new ArrayList<>());
        this.taskHistory = Collections.synchronizedList(new ArrayList<>());
    }

    public Task addToTaskList(Task newTask) {
        taskList.add(newTask);
        return newTask;
    }

    public void deleteTaskByID(String taskId) {
        Task taskToDelete = findTaskById(taskId);
        taskList.remove(taskToDelete);
        taskHistory.add(taskToDelete);
    }

    public void updateTaskStatus(String taskId, String status) {
        Task task = findTaskById(taskId);
        task.setStatus(status);
        if (status.equalsIgnoreCase("Completed")) {
            taskHistory.add(task);
            taskList.remove(task);
        }
    }

    public List<Task> getTaskHistory() {
        return new ArrayList<>(taskHistory);
    }

    public List<Task> getSortedTaskList(String sortBy) {
        return taskList.stream()
                .sorted((t1, t2) -> {
                    if (sortBy.equals("priority")) {
                        return Integer.compare(t1.getPriority(), t2.getPriority());
                    } else if (sortBy.equals("dueDate")) {
                        return t1.getDueDate().compareTo(t2.getDueDate());
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }

    public void assignTaskToUser(String taskId, User user) {
        Task task = findTaskById(taskId);
        task.setAssignedUser(user);
    }

    public void setTaskReminder(String taskId, Date reminderDate) {
        Task task = findTaskById(taskId);
        task.setReminderDate(reminderDate);
    }

    // Search tasks by status
    public List<Task> searchTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getStatus().equalsIgnoreCase(status)) {
                result.add(task);
            }
        }
        return result;
    }

    // Filter tasks by assigned user
    public List<Task> filterTasksByUser(User user) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getAssignedUser() != null && task.getAssignedUser().equals(user)) {
                result.add(task);
            }
        }
        return result;
    }

    // Filter tasks by priority
    public List<Task> filterTasksByPriority(int priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getPriority() == priority) {
                result.add(task);
            }
        }
        return result;
    }

    // Find a task by ID
    private Task findTaskById(String taskId) {
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Task not found");
    }
}
