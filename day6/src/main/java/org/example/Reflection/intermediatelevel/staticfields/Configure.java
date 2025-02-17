package org.example.Reflection.intermediatelevel.staticfields;

import java.lang.reflect.Field;

class Configuration {
    // Private static field
    private static String API_KEY = "OLD_SECRET_KEY";

    // Method to print API_KEY
    public static void printKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

