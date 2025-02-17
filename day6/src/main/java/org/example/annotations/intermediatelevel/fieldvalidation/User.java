package org.example.annotations.intermediatelevel.fieldvalidation;

import java.lang.annotation.*;
        import java.lang.reflect.Field;

// Step 1: Define the @MaxLength Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for Reflection
@Target(ElementType.FIELD) // Can be applied to fields only
@interface MaxLength {
    int value(); // Maximum length allowed
}

// Step 2: Apply the Annotation to a Field in User Class
class User {
    @MaxLength(10) // Maximum 10 characters allowed
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    // Step 3: Validate Field Length Using Reflection
    private void validateMaxLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();

                if (value.length() > maxLength) {
                    throw new IllegalArgumentException("Error: Username exceeds max length of " + maxLength + " characters!");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}