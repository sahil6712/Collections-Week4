package org.example.regex.advancedproblems.extractcurrencyvalues;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValue {

    // Method to extract currency values
    public static ArrayList<String> extractCurrency(String text) {

        // Arraylist to store the currency values
        ArrayList<String> currenyValues = new ArrayList<>();

        String regex = "(\\d+\\.\\d+)";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(text);

        while(matcher.find()) {
            currenyValues.add(matcher.group());
        }
        return currenyValues;
    }

    public static void main(String[] args) {

        // Text
        String text = "The price is $45.99 , and the discount is 10.50.";

        // Call method to get the output
        System.out.println(extractCurrency(text));
    }

}
