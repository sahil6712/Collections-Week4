package trywithresourcestest;

import org.example.trywithresources.FileReaderWithResources;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FileReaderWithResourcesTest {

    @Test
    void testFileExists() throws IOException {
        String testFileName = "test_info.txt";
        FileWriter writer = new FileWriter(testFileName);
        writer.write("Hello, World!");
        writer.close();

        String result = FileReaderWithResources.readFirstLine(testFileName);
        assertEquals("Hello, World!", result);

        new File(testFileName).delete(); // Clean up
    }

    @Test
    void testFileNotFound() {
        String result = FileReaderWithResources.readFirstLine("non_existent_file.txt");
        assertEquals("Error reading file", result);
    }
}

