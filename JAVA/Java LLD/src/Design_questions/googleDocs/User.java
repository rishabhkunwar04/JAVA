package Design_questions.googleDocs;

public class User {
    private String username;
    private String userId;

    public User ( String username,String userId){
        this.username=username;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
