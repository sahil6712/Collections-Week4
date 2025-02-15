package advanceproblemtest.validatecreditcard;

import org.example.regex.advancedproblems.validatecreditcard.ValidateCreditCard;
import org.example.regex.advancedproblems.validateipaddress.ValidateIpAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateCreditCardTest {

    @Test
    void testIsValid() {
        assertTrue(ValidateCreditCard.isValid("4123456789123456"));
        assertFalse(ValidateIpAddress.isValid("1234567891012345"));
    }
}
