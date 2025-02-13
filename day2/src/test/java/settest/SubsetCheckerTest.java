package settest;

import org.example.set.findsubsets.SubsetChecker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubsetCheckerTest {

    @Test
    void testIsSubset() {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        assertTrue(SubsetChecker.isSubset(set1, set2), "Set1 should be a subset of Set2");
    }

    @Test
    void testIsNotSubset() {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(2, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        assertFalse(SubsetChecker.isSubset(set1, set2), "Set1 should not be a subset of Set2");
    }
}
