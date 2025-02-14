package org.example.readuserinput;

import java.io.*;

public class ReadConsole {
    public static void main(String[] args) throws IOException {

        // Buffered Reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/org/example/readuserinput/writefile"));){

            System.out.println("Enter your name");
            bw.write(br.readLine());
            bw.newLine();
            System.out.println("Enter your age");
            bw.write(br.readLine());
            bw.newLine();
            System.out.println("Enter your programming language");
            bw.write(br.readLine());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
