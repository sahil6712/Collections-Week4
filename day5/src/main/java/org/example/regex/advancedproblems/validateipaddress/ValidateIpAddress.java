package org.example.regex.advancedproblems.validateipaddress;

import java.util.Scanner;
import java.util.regex.*;

public class ValidateIpAddress {

    // Method to validate the ip address
    public static boolean isValid(String str) {
        String pat = "(\\d{1,2}|([0|1])\\d{2}|2[0-4]\\d|25[0-5])\\.+" +
                "(\\d{1,2}|([0|1])\\d{2}|2[0-4]\\d|25[0-5])\\." +
                "(\\d{1,2}|([0|1])\\d{2}|2[0-4]\\d|25[0-5])\\." +
                "(\\d{1,2}|([0|1])\\d{2}|2[0-4]\\d|25[0-5])";
        Pattern p = Pattern.compile(pat);
        return p.matcher(str).matches();
    }

    public static void main(String[] args) {

        // Scanner object to take the user input
        Scanner input = new Scanner(System.in);

        // prompt the user to enter an ipaddress
        System.out.println("Enter ip to validate: ");
        String ipAddress = input.nextLine();

        // Call method to validate ip
        System.out.println(isValid(ipAddress));
    }
}
