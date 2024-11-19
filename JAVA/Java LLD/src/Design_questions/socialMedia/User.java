package Design_questions.socialMedia;

import java.util.List;

public class User {
    private String id;
    private String Name;
    private String Password;
    private String Email;
    private List<String> Friend;
    private String ProfilePicture;
   private  String Bio;
   List<Post>posts;

    public User(String id, String name, String password, String email,String profilePicture, String bio,List<String>friend,List<Post>posts) {
        this.id = id;
        Name = name;
        Password = password;
        Email = email;
        ProfilePicture = profilePicture;
        Bio = bio;
        Friend=friend;
        this.posts=posts;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getBio() {
        return Bio;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }
    public List<String> getFriendList(){
        return Friend;
    }
    public List<Post> getPost(){
        return posts;
    }
}
