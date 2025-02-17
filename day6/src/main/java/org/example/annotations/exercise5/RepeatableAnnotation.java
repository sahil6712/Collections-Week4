package org.example.annotations.exercise5;

import java.lang.reflect.Method;

public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        // Get the method
        Method method = Software.class.getMethod("processData");

        // Retrieve and print all bug reports
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Description: " + bug.description());
            }
        }
    }
}