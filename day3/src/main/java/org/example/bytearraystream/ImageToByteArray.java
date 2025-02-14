package org.example.bytearraystream;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "src/main/java/org/example/bytearraystream/img.png";
        String outputImagePath = "src/main/java/org/example/bytearraystream/output.png";

        try {
            // Convert image to byte array
            byte[] imageBytes = imageToByteArray(inputImagePath);

            // Convert byte array back to image
            byteArrayToImage(imageBytes, outputImagePath);

            // Verify the files are identical
            if (verifyFiles(inputImagePath, outputImagePath)) {
                System.out.println("Success! The images are identical.");
            } else {
                System.out.println("Error: The images are not identical.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    // Convert image file to byte array
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Convert byte array back to image file
    public static void byteArrayToImage(byte[] imageBytes, String outputImagePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputImagePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Verify if the two image files are identical
    public static boolean verifyFiles(String file1, String file2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(new File(file1).toPath());
        byte[] file2Bytes = Files.readAllBytes(new File(file2).toPath());
        return Arrays.equals(file1Bytes, file2Bytes);
    }
}
