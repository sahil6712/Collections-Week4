package settest;

import org.example.set.unionintersectionofsets.UnionIntersectionSets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class UnionIntersectionSetsTest {

    @Test
    void testFindIntersection() {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(3, 2, 6, 7, 1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> expectedIntersection = Arrays.asList(1, 2, 3);
        List<Integer> actualIntersection = UnionIntersectionSets.findIntersection(set1, set2);

        assertTrue(actualIntersection.containsAll(expectedIntersection) && expectedIntersection.containsAll(actualIntersection), "Intersection is incorrect");
    }

    @Test
    void testFindUnion() {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(3, 2, 6, 7, 1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        HashSet<Integer> expectedUnion = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        HashSet<Integer> actualUnion = UnionIntersectionSets.findUnion(set1, set2);

        assertEquals(expectedUnion, actualUnion, "Union is incorrect");
    }
}
