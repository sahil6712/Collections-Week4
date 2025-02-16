package org.example.regex.extractionpackage.extractemail;

import java.util.regex.*;
import java.util.*;

public class ExtractEmail {
    public static void main(String[] args) {
        String text = "Contact us at sahil327@gmail.com and band420@company.org";

        // Regular expression pattern for email addresses
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile pattern
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);

        // Store matches in a list (optional)
        List<String> emails = new ArrayList<>();

        // Find all matches
        while (matcher.find()) {
            emails.add(matcher.group());
        }

        // Print all extracted emails
        for (String email : emails) {
            System.out.println(email);
        }
    }
}

