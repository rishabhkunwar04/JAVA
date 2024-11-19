package Design_questions.inMemoryDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {
    private Map<String, Database> databases = new HashMap<>();

    // Create a new database
    public boolean createDatabase(String dbName) {
        if (databases.containsKey(dbName)) {
            return false; // Database already exists
        }
        databases.put(dbName, new Database(dbName));
        return true;
    }

    // Get a database by name
    public Database getDatabase(String dbName) {
        return databases.get(dbName);
    }

    // List all databases
    public List<String> listDatabases() {
        return new ArrayList<>(databases.keySet());
    }
}
