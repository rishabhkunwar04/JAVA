package Design_questions.taskManagmentSystem;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        TaskService taskService = new TaskService();

        User user1 = new User("u1", "Rishabh", "rishabh.kunwar04@gmail.com", "ADMIN");
        userService.addUser(user1);

        Task task1 = new Task("t1", "Design DB Schema", "Create DB schema for project", user1, Date.valueOf("2025-08-15"), 1);
        taskService.addToTaskList(task1);

        taskService.setTaskReminder("t1", Date.valueOf("2025-08-14"));
        taskService.updateTaskStatus("t1", "In Progress");

        System.out.println("Tasks: " + taskService.filterTasksByUser(user1).size());
        taskService.updateTaskStatus("t1", "Completed");

        System.out.println("Task History: " + taskService.getTaskHistory().size());
    }
}
