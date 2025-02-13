package maptest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.map.wordfrequencycounter.FrequencyCounter;

class FrequencyCounterTest {

    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file with test content
        tempFile = File.createTempFile("testFile", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("hello world hello world Hello");
        }
    }

    @AfterEach
    void tearDown() {
        // Delete the temporary file after the test
        assertTrue(tempFile.delete());
    }

    @Test
    void testGetCount() throws IOException {
        // Call the getCount method
        HashMap<String, Integer> result = FrequencyCounter.getCount(tempFile.getAbsolutePath());

        // Expected frequencies
        assertEquals(2, result.get("hello"));
        assertEquals(2, result.get("world"));
        assertEquals(1, result.get("Hello"));


        // Ensure that no unexpected characters exist
        assertEquals(3, result.size()); // "hello world" has 8 unique characters
    }
}
