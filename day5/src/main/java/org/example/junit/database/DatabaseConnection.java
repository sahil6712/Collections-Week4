package org.example.junit.database;

public class DatabaseConnection {

    private boolean isConnected;

    // Simulate connecting to a database
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    // Simulate disconnecting from a database
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    // Check if the connection is active
    public boolean isConnected() {
        return isConnected;
    }
}

