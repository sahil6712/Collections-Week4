package org.example.map.maxvaluekey;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class MaxValueKey {
    public static String getKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null; // Return null for empty maps
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("K", 40);
        map.put("S", 30);
        map.put("D", 15);

        String maxKey = getKeyWithMaxValue(map);
        System.out.println("Key with max value: " + maxKey); // Output: B
    }
}

