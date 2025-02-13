package org.example.queue.generatebinarynumber;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryNumberGenerator {

    // Method to generate first N binary numbers
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); // Start with "1"

        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            result.add(current);

            // Generate the next two binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " binary numbers: " + generateBinaryNumbers(N));
        // Output: ["1", "10", "11", "100", "101"]
    }
}
