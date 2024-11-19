package Design_questions.socialMedia;

import java.sql.Timestamp;

public class Notification {
    private String id;
    private String userid;
   private NotificationType notificationType;
   private Timestamp timestamp;
   private String content;

    public Notification(String id, String userid, NotificationType notificationType,String content, Timestamp timestamp) {
        this.id = id;
        this.userid = userid;
        this.notificationType = notificationType;
        this.timestamp = timestamp;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

}
