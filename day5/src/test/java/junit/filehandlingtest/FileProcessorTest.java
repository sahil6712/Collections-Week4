package junit.filehandlingtest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.filehandling.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Ensure test file is deleted before each test
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up test file after each test
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, this is a test.";
        FileProcessor.writeToFile(TEST_FILE, content);

        // Check if file exists
        assertTrue(Files.exists(Paths.get(TEST_FILE)), "File should exist after writing.");

        // Check if content matches
        String readContent = FileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "File content should match written content.");
    }

    @Test
    void testReadFromNonExistentFile_ShouldThrowException() {
        Exception exception = assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
        assertTrue(exception.getMessage().contains("nonexistent.txt"), "Exception message should mention missing file.");
    }
}
