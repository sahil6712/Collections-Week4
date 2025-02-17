package org.example.Reflection.intermediatelevel.retrieveannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Step 1: Define a custom annotation
@Retention(RetentionPolicy.RUNTIME) // Make annotation available at runtime
@interface Author {
    String name();
}

// Step 2: Apply annotation to a class
@Author(name = "John Doe")
class MyClass {
    public void display() {
        System.out.println("Hello from MyClass!");
    }
}

