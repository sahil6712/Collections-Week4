package org.example.annotations.advancedlevel.jsonserialization;

public class Main {
    public static void main(String[] args) {
        User user = new User("JohnDoe", 25, "securePassword123");

        String jsonOutput = JsonSerializer.toJson(user);
        System.out.println(jsonOutput);
    }
}
