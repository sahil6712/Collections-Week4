package queuetest.binarygenerator;

import org.example.queue.generatebinarynumber.BinaryNumberGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class BinaryNumberGeneratorTest {

    @Test
    void testGenerateBinaryNumbers() {
        int N = 5;
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");

        assertEquals(expected,
                BinaryNumberGenerator.generateBinaryNumbers(N),
                "Binary number generation is incorrect");
    }
}

