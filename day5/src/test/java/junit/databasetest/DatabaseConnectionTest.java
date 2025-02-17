package junit.databasetest;

import org.example.junit.database.DatabaseConnection;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();  // Simulate database connection before each test
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();  // Simulate disconnecting after each test
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "Database should be connected");
    }

    @Test
    void testConnectionIsClosedAfterEachTest() {
        dbConnection.disconnect();  // Explicitly close connection
        assertFalse(dbConnection.isConnected(), "Database should be disconnected");
    }
}
