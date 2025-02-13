package org.example.map.wordfrequencycounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    public static void main(String[] args) {

        // File path that is to be read
        String filePath = "src/main/java/org/example/map/wordfrequencycounter/textFile";

        HashMap<String, Integer> hs = new HashMap<>();

        // Call the method to get the word along wiht its frequency
        try {
            hs = getCount(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Output
        for(Map.Entry<String, Integer> ele : hs.entrySet()) {
            System.out.println(ele.getKey()+"\t"+ele.getValue());
        }
    }


    // Method to read the file and to get the count of each word in file
    public static HashMap<String, Integer> getCount(String filePath) throws IOException {

        // HashMap to store the word and their count
        HashMap<String, Integer> hs = new HashMap<>();

        try(
                BufferedReader br = new BufferedReader(new FileReader(filePath));
        ){

            String ch;

            // loop to read each and every word of the file
            while((ch = br.readLine()) != null) {
                String regex = "\\W+";
                String[] words = ch.split(regex);
                for (String word : words) {
                    if (hs.containsKey(word)) {
                        hs.put(word, (hs.get(word) + 1));
                    } else {
                        hs.put(word,1);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return hs;       // Returns a hashmap
    }
}
