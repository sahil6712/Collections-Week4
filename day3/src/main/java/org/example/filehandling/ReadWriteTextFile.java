package org.example.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteTextFile {

    // Method to read and write file
    public static void fileReadWrite(String inputFilePath, String outputFilePath) {

        // Try block
        try(
                // Stream to read byte and character stream
                FileInputStream fis = new FileInputStream(inputFilePath);

                // To write byte and character stream
                FileOutputStream fos = new FileOutputStream(outputFilePath);
                ) {

            int ch;

            // Loop to iterate the characters of input file and write to outputFile
            while((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            System.out.println("File Copied.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        // Input file
        String inputFilePath = "src/main/java/org/example/filehandling/inputfile";
        String outputFilePath = "src/main/java/org/example/filehandling/outputfile";

        // Call the method to read and write
        fileReadWrite(inputFilePath, outputFilePath);

    }
}
