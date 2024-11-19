package Design_questions.inMemoryDatabase;

public class Row {
    private int rowid; // Auto-incremented ID
     private String Name;
   private  int Age;


    public Row(int rowid, String name, int age){
        this.rowid = rowid;

        this.Name = name;
        this.Age = age;
    }

    public int getRowid() {
        return rowid;
    }

    public void setRowid(int rowid) {
        this.rowid = rowid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
