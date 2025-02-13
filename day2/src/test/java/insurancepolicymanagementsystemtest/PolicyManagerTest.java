package insurancepolicymanagementsystemtest;

import org.example.insurancepolicymanagementsystem.Policy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

import org.example.insurancepolicymanagementsystem.PolicyManager;

public class PolicyManagerTest {
    private PolicyManager manager;

    @BeforeEach
    void setUp() {
        manager = new PolicyManager();
        manager.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(10), "Health", 5000));
        manager.addPolicy(new Policy("P002", "Jane Smith", LocalDate.now().plusDays(40), "Auto", 7000));
        manager.addPolicy(new Policy("P003", "Alice Johnson", LocalDate.now().plusDays(5), "Home", 8000));
    }

    @Test
    void testGetAllPolicies() {
        assertEquals(3, manager.getAllPolicies().size());
    }

    @Test
    void testGetPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = manager.getPoliciesExpiringSoon();
        assertEquals(2, expiringSoon.size());
    }

    @Test
    void testGetPoliciesByCoverageType() {
        Set<Policy> healthPolicies = manager.getPoliciesByCoverageType("Health");
        assertEquals(1, healthPolicies.size());
    }

    @Test
    void testDuplicatePolicies() {
        manager.addPolicy(new Policy("P001", "Duplicate", LocalDate.now().plusDays(15), "Health", 4000));
        Set<Policy> duplicates = manager.getDuplicatePolicies();
        assertEquals(1, duplicates.size());
    }
}
