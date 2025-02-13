package org.example.map.invertmap;

import java.util.*;

public class MapInverter {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Check if the value already exists in the inverted map
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }

            // Add the key to the list of keys for this value
            invertedMap.get(value).add(key);
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("K", 1);
        input.put("S",2);

        System.out.println(invertMap(input)); // Expected Output: {1=[A, C], 2=[B]}
    }
}
