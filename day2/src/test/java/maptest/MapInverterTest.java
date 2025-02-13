package maptest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.map.invertmap.MapInverter;
import org.junit.jupiter.api.Test;
import java.util.*;

class MapInverterTest {

    @Test
    void testInvertMap() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(1, Arrays.asList("A", "C"));
        expected.put(2, Arrays.asList("B"));

        Map<Integer, List<String>> actual = MapInverter.invertMap(input);

        assertEquals(expected.keySet(), actual.keySet());
        assertTrue(actual.get(1).containsAll(Arrays.asList("A", "C")));
        assertTrue(actual.get(2).containsAll(Arrays.asList("B")));
    }

    @Test
    void testInvertMapWithEmptyInput() {
        Map<String, Integer> input = new HashMap<>();
        Map<Integer, List<String>> expected = new HashMap<>();

        assertEquals(expected, MapInverter.invertMap(input));
    }

    @Test
    void testInvertMapWithUniqueValues() {
        Map<String, Integer> input = new HashMap<>();
        input.put("X", 10);
        input.put("Y", 20);
        input.put("Z", 30);

        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(10, Collections.singletonList("X"));
        expected.put(20, Collections.singletonList("Y"));
        expected.put(30, Collections.singletonList("Z"));

        assertEquals(expected, MapInverter.invertMap(input));
    }
}

