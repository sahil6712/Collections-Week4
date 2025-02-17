package junit.passwordstrengthvalidatortest;


import org.example.junit.passwordstrengthvalidator.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("StrongPass1"), "Valid password should pass");
    }

    @Test
    void testPassword_TooShort() {
        assertFalse(PasswordValidator.isValid("Ab1"), "Password should be at least 8 characters long");
    }

    @Test
    void testPassword_NoUppercase() {
        assertFalse(PasswordValidator.isValid("weakpassword1"), "Password should contain at least one uppercase letter");
    }

    @Test
    void testPassword_NoDigit() {
        assertFalse(PasswordValidator.isValid("StrongPass"), "Password should contain at least one digit");
    }

    @Test
    void testPassword_Null() {
        assertFalse(PasswordValidator.isValid(null), "Null password should be invalid");
    }

    @Test
    void testPassword_EmptyString() {
        assertFalse(PasswordValidator.isValid(""), "Empty password should be invalid");
    }
}
