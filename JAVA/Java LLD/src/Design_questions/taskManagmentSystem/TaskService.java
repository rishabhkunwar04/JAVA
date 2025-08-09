package Design_questions.taskManagmentSystem;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    List<Task>taskList;
    List<Task>taskHistory;

      public TaskService(){
        this.taskList = new ArrayList<>();
        this.taskHistory = new ArrayList<>();
      }

    // Method to create a new task
    public Task addToTaskList( Task newTask) {
        taskList.add(newTask);
        return newTask;
    }
    // Method to Delete Task
    public void deleteTaskByID(String taskId) {
        Task taskToDelete = null;
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                taskToDelete = task;
                break;
            }
        }
        if (taskToDelete != null) {
            taskList.remove(taskToDelete);
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }
    //Method to Delete task
    public void deleteTask(Task task) {
        if (taskList.remove(task)) {
            taskHistory.add(task); // Optionally, add to history
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }

    // Method to update the status of a task
    public void updateTaskStatus(String taskId, String status) {
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                task.setStatus(status);
                if (status.equals("Completed")){
                    taskHistory.add(task); // Move to history if completed
                    taskList.remove(task); // Remove from current task list
                }
                return;
            }
        }
        throw new IllegalArgumentException("Task not found");
    }
    // Method to get all tasks
    public List<Task> getTaskHistory() {
        return new ArrayList<>(taskHistory);
    }


    // method to  sort tasks by priority
    public List<Task> getTasksSorted(String sortBy) {
        if (sortBy.equals("priority")) {
            taskList.sort((task1, task2) -> Integer.compare(task1.getPriority(), task2.getPriority()));
        }else if(sortBy.equals("dueDate")) {
            taskList.sort((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()));

        }else{
            throw new IllegalArgumentException("Provide valid criteria to sort tasks");
        }
        return new ArrayList<>(taskList);
    }

}
