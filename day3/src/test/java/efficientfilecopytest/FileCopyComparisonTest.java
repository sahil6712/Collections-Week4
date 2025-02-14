package efficientfilecopytest;
import org.example.efficientfilecopy.FileCopyComparison;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileCopyComparisonTest {
    private static final String SOURCE_FILE = "test_source.txt";
    private static final String DEST_BUFFERED_FILE = "test_dest_buffered.txt";
    private static final String DEST_UNBUFFERED_FILE = "test_dest_unbuffered.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a test source file with some content
        Files.write(Paths.get(SOURCE_FILE), "This is a test file.".getBytes());
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up test files
        Files.deleteIfExists(Paths.get(SOURCE_FILE));
        Files.deleteIfExists(Paths.get(DEST_BUFFERED_FILE));
        Files.deleteIfExists(Paths.get(DEST_UNBUFFERED_FILE));
    }

    @Test
    void testCopyUsingBufferedStreams() throws IOException {
        long timeTaken = FileCopyComparison.copyUsingBufferedStreams(SOURCE_FILE, DEST_BUFFERED_FILE);
        assertTrue(timeTaken > 0, "Time taken should be greater than 0");

        assertTrue(Files.exists(Paths.get(DEST_BUFFERED_FILE)), "Buffered copy file should exist");
        assertArrayEquals(Files.readAllBytes(Paths.get(SOURCE_FILE)),
                Files.readAllBytes(Paths.get(DEST_BUFFERED_FILE)),
                "File content should be the same after buffered copy");
    }

    @Test
    void testCopyUsingUnbufferedStreams() throws IOException {
        long timeTaken = FileCopyComparison.copyUsingUnbufferedStreams(SOURCE_FILE, DEST_UNBUFFERED_FILE);
        assertTrue(timeTaken > 0, "Time taken should be greater than 0");

        assertTrue(Files.exists(Paths.get(DEST_UNBUFFERED_FILE)), "Unbuffered copy file should exist");
        assertArrayEquals(Files.readAllBytes(Paths.get(SOURCE_FILE)),
                Files.readAllBytes(Paths.get(DEST_UNBUFFERED_FILE)),
                "File content should be the same after unbuffered copy");
    }

    @Test
    void testInvalidSourceFile() {
        Exception exception = assertThrows(IOException.class, () -> {
            FileCopyComparison.copyUsingBufferedStreams("non_existent_file.txt", DEST_BUFFERED_FILE);
        });
        assertTrue(exception.getMessage().contains("non_existent_file"), "Exception should mention the missing file");
    }
}
