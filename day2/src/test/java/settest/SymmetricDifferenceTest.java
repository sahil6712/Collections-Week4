package settest;

import org.example.set.symmetricdifference.SymmetricDifference;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

class SymmetricDifferenceTest {

    @Test
    void testFindSymmetricDifference() {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        HashSet<Integer> expectedSymmetricDifference = new HashSet<>(Arrays.asList(1, 2, 4, 5));
        HashSet<Integer> actualSymmetricDifference = SymmetricDifference.findSymmetricDifference(set1, set2);

        assertEquals(expectedSymmetricDifference, actualSymmetricDifference, "Symmetric Difference is incorrect");
    }
}

