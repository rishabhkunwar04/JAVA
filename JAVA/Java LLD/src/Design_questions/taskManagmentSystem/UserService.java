package Design_questions.taskManagmentSystem;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }

    // method to add user to the user list
    public User addUser(User newUser) {
        userList.add(newUser);
        return newUser;
    }
}
