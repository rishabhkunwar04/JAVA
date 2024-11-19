package org.example.InMemoryDB.Service;

import javafx.util.Pair;
import org.example.InMemoryDB.Dao.Database;

import java.util.ArrayList;
import java.util.List;

import static org.example.InMemoryDB.Constants.*;



public class InMemoryDb {

    private Database database;

    public InMemoryDb() {
        database = new Database();
    }

    public void action(String input) {
        String operation = input.split(" ")[0];
        operation = operation.toLowerCase();

        switch (operation) {
            case GET : {
                if(input.length() == 1) {
                    System.out.println("Please provide valid input");
                    return;
                }

                String key = input.split(" ")[1];
                if(database.get(key) == null) {
                    System.out.println("No entry found for, key : " + key);
                    return;
                }

                System.out.println(database.get(key));
                break;
            }

            case PUT : {
                String [] values = input.split(" ");
                String key = values[1];
                List<Pair< String, String> > inputList = new ArrayList<>();
                for(int i = 2; i < values.length; i+=2) {
                  inputList.add(new Pair<>(values[i], values[i+1]));
                }

                database.put(key, inputList);
                break;
            }

            case SEARCH : {
                String key = input.split(" ")[1];
                String value = input.split(" ")[2];
                String response = database.searchKeyValue(key, value);
                if(response != null) {
                    System.out.println(response);
                } else {
                    System.out.println("No value found for given input");
                }
                break;
            }

            case KEYS : {
                System.out.println(database.getKeys());
                break;
            }

            case DELETE : {
                String key = input.split(" ")[1];
                database.delete(key);
                break;
            }

            case EXIT : {
                database.exitDb();
                break;
            }

            default:{
                System.out.println("Invalid operation");
            }
        }
    }
}
