package Design_questions.inMemoryDatabase;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();

        // Create databases
        dbManager.createDatabase("db1");
        dbManager.createDatabase("db2");

        // List databases
        System.out.println("Databases: " + dbManager.listDatabases());

        // Get a database
        Database db1 = dbManager.getDatabase("db1");

        // Create tables in db1
        db1.createTable("users");
        db1.createTable("employees");

        // List tables in db1
        System.out.println("Tables in db1: " + db1.listTables());

        // Perform operations on the "users" table
        Table usersTable = db1.getTable("users");

        // Insert rows
        Row row1 = usersTable.insert("Alice", 25);
        Row row2 = usersTable.insert("Bob", 30);

        System.out.println("Inserted rows:");
        for (Row row : usersTable.getAllRows()) {
            System.out.println(row);
        }

        // Update a row
        usersTable.update(row1.getRowid(), "Alice Smith", 26);

        // Delete a row
      //  usersTable.delete(row2.getRowid());

        // Fetch all rows
//        System.out.println("Rows after update and delete:");
//        for (Row row : usersTable.getAllRows()) {
//            System.out.println(row);
//        }
    }
}
