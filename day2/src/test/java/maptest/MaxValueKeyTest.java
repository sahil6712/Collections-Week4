package maptest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.map.maxvaluekey.MaxValueKey;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;

class MaxValueKeyTest {

    @Test
    void testGetKeyWithMaxValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        assertEquals("B", MaxValueKey.getKeyWithMaxValue(map));
    }

    @Test
    void testEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        assertNull(MaxValueKey.getKeyWithMaxValue(map));
    }

    @Test
    void testSingleElementMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("X", 42);

        assertEquals("X", MaxValueKey.getKeyWithMaxValue(map));
    }

    @Test
    void testMultipleMaxValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 30);
        map.put("B", 30);
        map.put("C", 20);

        // Since Collections.max returns the first occurrence, expected result is "A" or "B"
        assertTrue(map.get(MaxValueKey.getKeyWithMaxValue(map)) == 30);
    }
}

