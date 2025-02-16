package org.example.regex.replacemodifystrings;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        // Sample input
        String input = "Tiger is  the  most powerful          animal            of the forest .";

        // Replace multiple spaces with a single space using regex
        String output = input.replaceAll("\\s+", " ");

        // Output
        System.out.println(output);
    }
}
