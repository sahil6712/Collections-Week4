package org.example.Reflection.advancedlevel.customobjectmapper;

import java.util.Map;

public class CustomObject{
    public static void main(String[] args) {
        // Step 3: Create a map of properties
        Map<String, Object> properties = Map.of(
                "name", "Alice",
                "age", 25
        );

        // Step 4: Convert map to Person object
        ObjectMap ObjectMapper = null;
        Person person = ObjectMapper.toObject(Person.class, properties);

        // Display the object's field values
        if (person != null) {
            person.display();
        }
    }
}
