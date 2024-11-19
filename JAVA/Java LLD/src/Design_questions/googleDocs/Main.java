package Design_questions.googleDocs;

public class Main {
    public static void main(String[] args) {
        User user1=new User("Rishabh","rishabh1");
        User user2 =new User("Sumit","sumit1");
        User user3=new User("Sushant","sushant1");

        Document doc=new Document(user1,"intial content !! ","myDoc");

        System.out.println(doc.getContent());
        doc.writeContent(user1,"content added by owner");
        System.out.println(doc.getContent());

        doc.grantAccess(user2,Permission.READ);
        doc.revokeAccess(user2,Permission.READ);

        doc.readContent(user2);

    }
}
