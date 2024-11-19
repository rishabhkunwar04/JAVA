package Design_questions.googleDocs;

import java.util.HashMap;
import java.util.Map;

public class Document {

    private String content;
    private String docName;
    private String docId;
    private
    Map<String,Permission>docMap;
    public Document(User user,String content, String docName){
        this.content = content;
        this.docName = docName;
        docMap=new HashMap<>();
        docMap.put(user.getUserId(),Permission.OWNER);
    }
    public void  grantAccess(User user,Permission type){
        docMap.put(user.getUserId(),type);
    }
    public void revokeAccess (User user,Permission type){
        docMap.remove(user.getUserId());
    }
    public String getContent() {
        return content;
    }
    public void writeContent(User user,String Content) {
        //logic to check permission
        if(docMap.containsKey(user.getUserId()) && (docMap.get(user.getUserId()).equals(Permission.OWNER) || docMap.get(user.getUserId()).equals(Permission.WRITE)  )){
            this.content+=Content;
            System.out.println("Content written by "+user.getUsername());
        }else{
            System.out.println("Permission denied  WRITE!!");
        }
    }
    public void readContent(User user) {
        //logic to check permission
        if(docMap.containsKey(user.getUserId()) && ( docMap.get(user.getUserId()).equals(Permission.OWNER) ||docMap.get(user.getUserId()).equals(Permission.READ)  )){
             getContent();
            System.out.println("Content read by "+user.getUsername());
        }else{
            System.out.println("Permission denied to READ !!");
        }
    }
    public void deleteContent(User user) {
        //logic to check permission
        if(docMap.containsKey(user.getUserId()) && docMap.get(user.getUserId()).equals(Permission.OWNER)){
            this.content="";
            System.out.println("Content deleted by "+user.getUsername());
        }else{
            System.out.println("Permission denied to Deleted !!");
        }
    }
}
