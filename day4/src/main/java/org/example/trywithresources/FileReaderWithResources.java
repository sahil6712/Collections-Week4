package org.example.trywithresources;

import java.io.*;

public class FileReaderWithResources {
    public static String readFirstLine(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();
        } catch (IOException e) {
            return "Error reading file";
        }
    }

    public static void main(String[] args) {
        String result = readFirstLine("info.txt");
        System.out.println(result);
    }
}
