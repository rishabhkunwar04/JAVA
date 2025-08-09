package Design_questions.taskManagmentSystem;

import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private  String permissionLevel; // Assuming permissionLevel is an enum or class
   // List<Task> arrayListOfTasks;

    public User(String userId, String name, String email,String permissionLevel) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.permissionLevel = permissionLevel;
    }


    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }
}
