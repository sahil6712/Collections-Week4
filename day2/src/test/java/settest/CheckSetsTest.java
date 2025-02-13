package settest;

import org.example.set.checktwosetsareequal.CheckSets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class CheckSetsTest {

    HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
    HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1,2,3));

    @Test
    void testFindSetsEqual() {
        assertTrue(CheckSets.findSetsEqual(set1, set2));
    }
}
