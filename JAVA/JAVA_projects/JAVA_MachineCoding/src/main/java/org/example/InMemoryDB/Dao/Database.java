package org.example.InMemoryDB.Dao;

import javafx.util.Pair;
import lombok.Data;
import org.example.InMemoryDB.Model.Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static javafx.application.Platform.exit;

@Data
public class Database {
    private Cache cacheObj;

    public Database() {
        cacheObj = new Cache();
    }

    public String get(String key) {
        if(!cacheObj.cache.containsKey(key)) {
            return null;
        }

        Map<String, Object> values = cacheObj.cache.get(key);
        String response = "";

        for(String k : values.keySet()) {
            response = response + k + " : " + values.get(k) + " , ";
        }

        return response;
    }

    public void put(String key, List<Pair <String, String> > input) {
        Map<String, Object> map = new HashMap<>();
        for(Pair p : input) {
            map.put((String) p.getKey(), p.getValue());
        }
       cacheObj.cache.put(key, map);
    }

    public String getKeys() {
        String response = String.join(" , " , cacheObj.cache.keySet());
        return response;
    }

    public String searchKeyValue(String key, String value) {
        List<String> existingKey = cacheObj.cache.keySet().stream().filter((k) -> k.equals(key)).collect(Collectors.toList());

        if(existingKey != null) {
            return String.join(" , ", existingKey);
        }

        return null;
    }

    public void delete(String key) {
        cacheObj.cache.remove(key);
    }

    public void exitDb() {
        System.out.println("Exiting database");
        System.exit(0);
    }

}
