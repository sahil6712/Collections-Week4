package filehandlingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.filehandling.ReadWriteTextFile;

    class ReadWriteTextFileTest {

        @TempDir
        Path tempDir;

        private Path inputFile;
        private Path outputFile;

        @BeforeEach
        void setUp() throws IOException {
            inputFile = tempDir.resolve("inputfile.txt");
            outputFile = tempDir.resolve("outputfile.txt");

            // Writing sample content to input file
            Files.writeString(inputFile, "Hello, this is a test file.");
        }

        @Test
        void testFileReadWrite() throws IOException {
            // Call the method to copy file content
            ReadWriteTextFile.fileReadWrite(inputFile.toString(), outputFile.toString());

            // Verify output file exists
            assertTrue(Files.exists(outputFile), "Output file should exist");

            // Verify content is the same
            String inputContent = Files.readString(inputFile);
            String outputContent = Files.readString(outputFile);
            assertEquals(inputContent, outputContent, "File contents should match");
        }
    }
