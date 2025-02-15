package advanceproblemtest.extractwordsfromtexttest;

import org.example.regex.advancedproblems.extractwordsfromtext.ExtractProgrammingLanguage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractProgrammingLanguageTest {

    @Test
    void testExtractLanguage() {
        assertEquals(new ArrayList<>(Arrays.asList("Java")), ExtractProgrammingLanguage.extractLanguage("Ram loves to code in Java"));
    }
}
