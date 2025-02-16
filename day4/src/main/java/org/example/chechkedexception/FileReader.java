package org.example.chechkedexception;

import java.io.*;

public class FileReader {
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "File not found";
        }
        return content.toString().trim();
    }

    public static void main(String[] args) {
        String result = readFile("src/main/java/org/example/chechkedexception/textfile");
        System.out.println(result);
    }
}