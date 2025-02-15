package org.example.regex.advancedproblems.extractwordsfromtext;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLanguage {

    // Method to extract languages
    public static ArrayList<String> extractLanguage(String text) {

        // To store words extracted from text
        ArrayList<String> languages = new ArrayList<>();

        String regex = "(\\b(Java|Python|JavaScript|Go)\\b)";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(text);

        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;  // Returns ArrayList of languages
    }

    public static void main(String[] args) {

        // Text form we need to extract programming languages
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // To store languages
        ArrayList<String> languages;

        // Call the method
        languages = extractLanguage(text);

        //Output
        System.out.println(languages);


    }
}
