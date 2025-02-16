package org.example.regex.extractionpackage.extractcapitalwords;

import java.util.regex.*;
import java.util.*;

public class CapitalizeWords {
    public static void main(String[] args) {
        String text = "Hi bye Tie Hello.";

        // Regular expression pattern for capitalized words
        String capitalizedRegex = "\\b[A-Z][a-z]*\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(capitalizedRegex);
        Matcher matcher = pattern.matcher(text);

        // List to store matched words
        List<String> capitalizedWords = new ArrayList<>();

        // Find all matches
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        // Print the extracted capitalized words as a comma-separated string
        System.out.println(String.join(", ", capitalizedWords));
    }
}
