package org.example.InMemoryDB.Model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cache {
    public Map<String, Map<String, Object>> cache;

    public  Cache() {
        cache = new HashMap<>();
    }
}
