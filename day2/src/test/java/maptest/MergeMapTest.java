package maptest;

import org.example.map.mergemap.MergeMap;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MergeMapTest {

    @Test
    void testMergeMaps() {
        // Given: Two input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // When: Merging the maps
        Map<String, Integer> mergedMap = MergeMap.mergeMaps(map1, map2);

        // Then: Verify the result
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("A", 1);
        expectedMap.put("B", 5); // 2 + 3 = 5
        expectedMap.put("C", 4);

        assertEquals(expectedMap, mergedMap, "Merged map should match the expected map.");
    }

    @Test
    void testMergeWithEmptyMap() {
        // Given
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("X", 10);
        map1.put("Y", 20);

        Map<String, Integer> map2 = new HashMap<>(); // Empty map

        // When
        Map<String, Integer> mergedMap = MergeMap.mergeMaps(map1, map2);

        // Then
        assertEquals(map1, mergedMap, "Merging with an empty map should return the original map.");
    }

    @Test
    void testMergeEmptyMaps() {
        // Given
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // When
        Map<String, Integer> mergedMap = MergeMap.mergeMaps(map1, map2);

        // Then
        assertTrue(mergedMap.isEmpty(), "Merging two empty maps should return an empty map.");
    }

    @Test
    void testMergeWithNullValues() {
        // Given
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("P", null);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("P", 5);

        // When
        Map<String, Integer> mergedMap = MergeMap.mergeMaps(map1, map2);

        // Then
        assertEquals(5, mergedMap.get("P"), "Merging a null value with an integer should result in the integer value.");
    }
}
