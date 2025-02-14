package org.example.pipedstream;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream outputStream;

    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            outputStream.write(message.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



