package junit.stringutilitytest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.testingcalculator.stringutility.StringUtils;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
    StringUtils stringUtils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("dcba", stringUtils.reverse("abcd"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }
}