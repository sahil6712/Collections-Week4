package org.example.annotations.exercise5;


import java.lang.annotation.*;
        import java.lang.reflect.Method;

// Step 1: Define the Repeatable Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@Repeatable(BugReports.class) // Mark as repeatable
@interface BugReport {
    String description();
}

// Step 2: Define the Container Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value(); // Array to hold multiple BugReport annotations
}

// Step 3: Apply the Annotation Multiple Times
class Software {

    @BugReport(description = "NullPointerException on edge cases")
    @BugReport(description = "Performance issue when processing large data")
    public void processData() {
        System.out.println("Processing data...");
    }
}


