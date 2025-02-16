package org.example.regex.censorbadwords;

public class CensorBadWords {
    public static void main(String[] args) {
        // Example input
        String text = "This is a damn bad example with some stupid words.";

        // List of bad words to censor
        String[] badWords = {"damn", "stupid"};

        // Censor bad words
        for (String badWord : badWords) {
            text = text.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }

        // Print the censored output
        System.out.println(text);
    }
}
