package org.example.annotations.intermediatelevel.fieldvalidation;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnCeff"); // ✅ Valid
            System.out.println("User created: " + user1.getUsername());

            User user2 = new User("SuperLongUsername123"); // ❌ Should throw an exception
            System.out.println("User created: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
