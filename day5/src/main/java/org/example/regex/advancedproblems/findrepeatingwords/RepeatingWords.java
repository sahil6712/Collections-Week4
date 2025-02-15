package org.example.regex.advancedproblems.findrepeatingwords;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWords {

    // Method to find repeating words
    public static void findRepeatingWords(String input) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\b\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        Set<String> repeatedWords = new HashSet<>();

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }

        System.out.println(String.join(", ", repeatedWords));
    }

    public static void main(String[] args) {

        // String text
        String text = "Find repeating words Words Find";

        // Call the method
        findRepeatingWords(text);
    }
}
