package Design_questions.socialMedia;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SocialNetworkService {
    private static SocialNetworkService instance;
  private Map<String, User>userMap;
  private Map<String,Post>postMap;
  private  Map<String, List<Notification>> notificationMap;


    private SocialNetworkService(){
        userMap=new ConcurrentHashMap<>();
        postMap=new ConcurrentHashMap<>();
        notificationMap=new ConcurrentHashMap<>();
  }
    public  synchronized static SocialNetworkService getInstance() {

      if(instance==null){
          instance=new SocialNetworkService();
      }
        return instance;
    }

    //createuser
    public void createUser(User user){
      userMap.put(user.getId(),user);
    }

    //login
    public User login(String email,String password){
        for(User user: userMap.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }

        }
        return null;
    }

    //updateProfile
    public void updateUserProfile(User user){
        userMap.put(user.getId(),user);
    }

    //send-friendRequest
    public void sendfriendRequest(String senderID,String receiverID){
        User receiver=userMap.get(receiverID);
        if(receiver!=null) {
            Notification notification = new Notification(generateNotificationId(), receiverID,NotificationType.FRIEND_REQUEST ,"Friend request from " + senderID, new Timestamp(System.currentTimeMillis()));

            //add notification object to notification Map
            addNotification(receiverID,notification);
        }
    }

    //acceptFriendRequest
    public void acceptfriendRequest (String receiverId,String senderId){

        User sender=userMap.get(senderId);
        User receiver=userMap.get(receiverId);

        if(sender!=null && receiver!=null){
            sender.getFriendList().add(receiverId);
            receiver.getFriendList().add(senderId);
            Notification notification = new Notification(generateNotificationId(),senderId ,NotificationType.FRIEND_REQUEST_ACCEPTED ,"Friend request from " + receiverId, new Timestamp(System.currentTimeMillis()));

            //add notification object to notification Map
            addNotification(senderId,notification);
        }
    }
    //CreatePost
    public void createPost(Post post) {
        postMap.put(post.getId(), post);
        User user = userMap.get(post.getUserId());
        if (user != null) {
            user.getPost().add(post);
        }
    }
    //Comment on post
    public void commentOnPost(Comment comment) {
        Post post = postMap.get(comment.getPostId());
        if (post != null) {
            post.getComments().add(comment);
            Notification notification = new Notification(generateNotificationId(), post.getUserId(),
                    NotificationType.COMMENT, "Your post received a comment from " + comment.getUserId(),
                    new Timestamp(System.currentTimeMillis()));
            addNotification(post.getUserId(), notification);
        }
    }

    //like on post
    public void likePost(String userId, String postId) {
        Post post = postMap.get(postId);
        if (post != null && !post.getLikes().contains(userId)) {
            post.getLikes().add(userId);
            Notification notification = new Notification(generateNotificationId(), post.getUserId(),
                    NotificationType.LIKE, "Your post was liked by " + userId,
                    new Timestamp(System.currentTimeMillis()));
            addNotification(post.getUserId(), notification);
        }
    }

 // addNotofication
    public void addNotification(String  receiverId,Notification notification){
        if(!notificationMap.containsKey(receiverId)){
            notificationMap.put(receiverId,new ArrayList<>());
        }
        notificationMap.get(receiverId).add(notification);
    }
    //generateNotificationId
    public String generateNotificationId(){
        return UUID.randomUUID().toString();
    }

    //get notification
    public List<Notification> getNotifications(String userId) {
        return notificationMap.getOrDefault(userId, new ArrayList<>());
    }

}
