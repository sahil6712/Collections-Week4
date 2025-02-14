package org.example.filterstreams;

import java.io.*;

public class TextFileConverter {
    public static void convertFileToLowercase(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {

        String inputFile = "src/main/java/org/example/filterstreams/inputFile";
        String outputFile = "src/main/java/org/example/filterstreams/outputFile";

        try {
            convertFileToLowercase(inputFile, outputFile);
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
