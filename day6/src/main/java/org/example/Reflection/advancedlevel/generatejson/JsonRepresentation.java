package org.example.Reflection.advancedlevel.generatejson;

public class JsonRepresentation {
    public static void main(String[] args) {
        // Create an object
        Person person = new Person("Alice", 25, true);

        // Convert to JSON
        JSON JsonConverter;
        String json = JSON.toJson(person);

        // Print the JSON representation
        System.out.println(json);
    }
}

