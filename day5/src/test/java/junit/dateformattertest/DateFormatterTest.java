package junit.dateformattertest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.dateformatter.DateFormatter;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("15-02-2025", DateFormatter.formatDate("2025-02-15"), "Should correctly format the date");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), "Should correctly format the date");
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("15-02-2025"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testInvalidDateValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2025-13-40"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
        assertEquals("Invalid date format. Expected yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(null));
        assertEquals("Invalid date format. Expected yyyy-MM-dd", exception.getMessage());
    }
}
