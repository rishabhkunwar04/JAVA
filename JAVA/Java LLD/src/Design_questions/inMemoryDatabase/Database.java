package Design_questions.inMemoryDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private String name;
    private Map<String, Table> tables = new HashMap<>();

    public Database(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Create a new table
    public boolean createTable(String tableName) {
        if (tables.containsKey(tableName)) {
            return false; // Table already exists
        }
        tables.put(tableName, new Table(tableName));
        return true;
    }

    // Get a table by name
    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    // List all tables
    public List<String> listTables() {
        return new ArrayList<>(tables.keySet());
    }
}
