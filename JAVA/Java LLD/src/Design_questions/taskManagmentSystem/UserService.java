package Design_questions.taskManagmentSystem;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }

    public User addUser(User newUser) {
        userList.add(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }
}
