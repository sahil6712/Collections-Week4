package org.example.regex.extractionpackage.extractdates;

import java.util.regex.*;
import java.util.*;

public class DateExtractor {
    public static void main(String[] args) {
        String text = "My birthday is on 09/10/2003.";

        // Regular expression to match dd/mm/yyyy format
        String datePattern = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(text);

        // Store matched dates
        List<String> dates = new ArrayList<>();
        while (matcher.find()) {
            dates.add(matcher.group());
        }

        // Print extracted dates
        System.out.println(String.join(", ", dates));
    }
}
