package readuserinputtest;

import org.example.readuserinput.ReadConsole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadConsoleTest {
    private final String testFilePath = "src/main/java/org/example/readuserinput/writefile";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture console output
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        // Restore original System.out and System.in
        System.setOut(originalOut);
        System.setIn(originalIn);

        // Clean up the test file
        new File(testFilePath).delete();
    }

    @Test
    void testReadConsole() throws Exception {
        // Simulate user input (name, age, programming language)
        String simulatedInput = "John Doe\n25\nJava\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Run the main method
        ReadConsole.main(new String[]{});

        // Verify file content
        File file = new File(testFilePath);
        assertTrue(file.exists(), "Output file should exist");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals("John Doe", reader.readLine());
            assertEquals("25", reader.readLine());
            assertEquals("Java", reader.readLine());
        }

        // Verify console output (optional)
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Enter your name"));
        assertTrue(consoleOutput.contains("Enter your age"));
        assertTrue(consoleOutput.contains("Enter your programming language"));
    }
}
