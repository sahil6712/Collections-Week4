package org.example.annotations.beginnerlevel.markimportantmethods;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the Annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.METHOD) // Can be applied to methods only
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

// Step 2: Apply the Annotation to Multiple Methods
class TaskHandler {

    @ImportantMethod(level = "CRITICAL")
    public void processTask() {
        System.out.println("Processing critical task...");
    }

    @ImportantMethod // Default level = "HIGH"
    public void logTask() {
        System.out.println("Logging task...");
    }

    public void helperMethod() {
        System.out.println("Helper method, not important.");
    }
}

