package org.example.list.frequencyofelements;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfStrings {

    // Method to find the frequency
    public static HashMap<String, Integer> frequencyFinder(String[] str) {
        // HashMap
        HashMap<String, Integer> freq = new HashMap<>();

        for(int i=0; i<str.length; i++) {
            if(freq.containsKey(str[i])) {
                int count = freq.get(str[i]);  // to store the frequency of any array
                freq.put(str[i],++count);
            }
            else {
                freq.put(str[i], 1);
            }
        }
        return freq;    // Return hashmap
    }
    public static void main(String[] args) {

        // List of strings
        String[] str = {"apple", "apple", "kela", "kela", "grenade","grenade","anaconda","fdf"};

        // Call method to get the frequency of each unique string
        HashMap<String, Integer> freq = frequencyFinder(str);

        // Display the result
        for(Map.Entry<String, Integer> f:freq.entrySet()) {
            System.out.println(f.getKey()+" "+f.getValue());
        }
    }
}
