package org.example.efficientfilecopy;

import java.io.*;

public class FileCopyComparison {
    private static final int BUFFER_SIZE = 4096;

    // Method to copy file using Buffered Streams
    public static long copyUsingBufferedStreams(String source, String destination) throws IOException {
        long startTime = System.nanoTime();
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        return System.nanoTime() - startTime; // Return execution time
    }

    // Method to copy file using Unbuffered Streams
    public static long copyUsingUnbufferedStreams(String source, String destination) throws IOException {
        long startTime = System.nanoTime();
        try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(destination)
        ) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        }
        return System.nanoTime() - startTime; // Return execution time
    }

    public static void main(String[] args) {
        String src = "src/main/java/org/example/efficientfilecopy/sourcefile";
        String destBuffered = "src/main/java/org/example/efficientfilecopy/destUnbufferedfile";
        String destUnbuffered = "src/main/java/org/example/efficientfilecopy/destbufferedfile";

        try {
            long bufferedTime = copyUsingBufferedStreams(src, destBuffered);
            long unbufferedTime = copyUsingUnbufferedStreams(src, destUnbuffered);

            System.out.println("Time taken using Buffered Streams: " + (bufferedTime / 1_000_000) + " ms");
            System.out.println("Time taken using Unbuffered Streams: " + (unbufferedTime / 1_000_000) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
