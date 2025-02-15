package org.example.regex.advancedproblems.validatessn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {

    // Method to validate ssn
    public static void validateSSN(String input) {
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid");
            found = true;
        }
        if (!found) {
            System.out.println("No valid SSN found in: \"" + input + "\"");
        }
    }
    public static void main(String[] args) {

        String sample1 = "My SSN is 123-45-6789";
        // Call the method
        validateSSN(sample1);

    }
}
