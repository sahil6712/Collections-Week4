package advanceproblemtest.extractcurrencyvaluestest;

import org.example.regex.advancedproblems.extractcurrencyvalues.ExtractCurrencyValue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractCurrencyValueTest {

    @Test
    void testExtractCurrency() {
        assertEquals(Arrays.asList("45.99", "10.50"), ExtractCurrencyValue.extractCurrency("The price is $45.99 , and the discount is 10.50."));
    }
}
