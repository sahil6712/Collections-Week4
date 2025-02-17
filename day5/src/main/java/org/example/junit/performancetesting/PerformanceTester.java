package org.example.junit.performancetesting;


public class PerformanceTester {

    // Simulates a long-running task (3 seconds delay)
    public static String longRunningTask() {
        try {
            Thread.sleep(3000);  // Simulates a delay of 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}
