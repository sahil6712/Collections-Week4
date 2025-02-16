package org.example.customexception;


public class AgeValidator {
    public static String validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
        return "Valid age";
    }

    public static void main(String[] args) {
        try {
            System.out.println(validateAge(20)); // Should print "Valid age"
            System.out.println(validateAge(16)); // Should throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
