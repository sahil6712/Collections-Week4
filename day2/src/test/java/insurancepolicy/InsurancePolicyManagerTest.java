package insurancepolicy;

import org.example.insurancepolicy.InsurancePolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.example.insurancepolicy.InsurancePolicyManager;

public class InsurancePolicyManagerTest {
    private InsurancePolicyManager policyManager;

    @BeforeEach
    public void setUp() {
        policyManager = new InsurancePolicyManager();
        policyManager.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(10)));
        policyManager.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40)));
        policyManager.addPolicy(new InsurancePolicy("P003", "Alice", LocalDate.now().plusDays(20)));
        policyManager.addPolicy(new InsurancePolicy("P004", "Charlie", LocalDate.now().minusDays(5))); // Expired
    }

    @Test
    public void testGetPolicyByNumber() {
        InsurancePolicy policy = policyManager.getPolicyByNumber("P001");
        assertNotNull(policy);
        assertEquals("Alice", policy.getPolicyHolderName());
    }

    @Test
    public void testGetPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = policyManager.getPoliciesExpiringSoon();
        assertEquals(2, expiringPolicies.size()); // Only P001 and P003 expire within 30 days
    }

    @Test
    public void testGetPoliciesByHolder() {
        List<InsurancePolicy> alicePolicies = policyManager.getPoliciesByHolder("Alice");
        assertEquals(2, alicePolicies.size());
    }

    @Test
    public void testRemoveExpiredPolicies() {
        policyManager.removeExpiredPolicies();
        assertNull(policyManager.getPolicyByNumber("P004")); // P004 was expired and should be removed
    }

    @Test
    public void testGetAllPolicies() {
        List<InsurancePolicy> allPolicies = policyManager.getAllPolicies();
        assertEquals(3, allPolicies.size()); // P004 was expired and removed
    }
}
