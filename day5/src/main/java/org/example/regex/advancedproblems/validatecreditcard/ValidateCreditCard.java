package org.example.regex.advancedproblems.validatecreditcard;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCreditCard {

    public static boolean isValid(String str) {
        String regex = "^(4|5)\\d{15}";

        Pattern p = Pattern.compile(regex);

        return p.matcher(str).matches();
    }
    public static void main(String[] args) {

        // Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter card number
        String cardNumebr = input.nextLine();

        // Output
        System.out.println("The entered card number is valid? "+isValid(cardNumebr));
    }
}
