package insurancepolicymanagementsystemtest;

import java.time.LocalDate;
import java.util.*;

import org.example.insurancepolicymanagementsystem.Policy;

public class PerformanceTest {
    public static void main(String[] args) {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        int dataSize = 100000;
        List<Policy> policies = new ArrayList<>();

        for (int i = 0; i < dataSize; i++) {
            policies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Auto", 5000 + (i % 1000)));
        }

        measurePerformance("HashSet", hashSet, policies);
        measurePerformance("LinkedHashSet", linkedHashSet, policies);
        measurePerformance("TreeSet", treeSet, policies);
    }

    private static void measurePerformance(String setType, Set<Policy> set, List<Policy> policies) {
        long startTime, endTime;

        // Adding policies
        startTime = System.nanoTime();
        set.addAll(policies);
        endTime = System.nanoTime();
        System.out.println(setType + " - Add time: " + (endTime - startTime) / 1e6 + " ms");

        // Searching a policy
        Policy searchPolicy = policies.get(policies.size() / 2);
        startTime = System.nanoTime();
        boolean found = set.contains(searchPolicy);
        endTime = System.nanoTime();
        System.out.println(setType + " - Search time: " + (endTime - startTime) / 1e6 + " ms");

        // Removing a policy
        startTime = System.nanoTime();
        set.remove(searchPolicy);
        endTime = System.nanoTime();
        System.out.println(setType + " - Remove time: " + (endTime - startTime) / 1e6 + " ms");
        System.out.println();
    }
}
