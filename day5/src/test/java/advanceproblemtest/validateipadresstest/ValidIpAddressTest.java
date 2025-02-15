package advanceproblemtest.validateipadresstest;

import org.example.regex.advancedproblems.validateipaddress.ValidateIpAddress;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ValidIpAddressTest {

    @Test
    void testIsValid() {
        assertTrue(ValidateIpAddress.isValid("123.123.123.123"));
        assertFalse(ValidateIpAddress.isValid("123.123.123"));
    }

}
