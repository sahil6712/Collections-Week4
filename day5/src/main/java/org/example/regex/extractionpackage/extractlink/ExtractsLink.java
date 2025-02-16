package org.example.regex.extractionpackage.extractlink;

import java.util.regex.*;
import java.util.*;

public class ExtractsLink {
    public static void main(String[] args) {
        // Example input text
        String text = "For help visit this site https://www.google.com.";

        // Regular expression for matching URLs
        String regex = "(https?://[\\w.-]+(?:\\.[a-zA-Z]{2,6})?(?:/[\\w\\d%_.~+-]*)*)";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted URLs
        List<String> links = new ArrayList<>();

        // Find and store URLs
        while (matcher.find()) {
            links.add(matcher.group());
        }

        // Print extracted links
        System.out.println(String.join(", ", links));
    }
}
