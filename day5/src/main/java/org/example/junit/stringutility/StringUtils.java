package org.example.junit.stringutility;

public class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {

        // String
        String str = "Sahil";

        // Object of the class
        StringUtils strUtility = new StringUtils();

        // Call methods to perform operations on string
        System.out.println("Reversed string is: "+strUtility.reverse(str));
        System.out.println("Is string palindroe: "+strUtility.isPalindrome(str));
        System.out.println("Upper case string: "+strUtility.toUpperCase(str));
    }
}