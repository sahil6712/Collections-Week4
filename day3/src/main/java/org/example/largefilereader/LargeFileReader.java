package org.example.largefilereader;

import java.io.*;

public class LargeFileReader {
    public static void readLargeFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java LargeFileReader <filename>");
            return;
        }
        readLargeFile(args[0]);
    }
}