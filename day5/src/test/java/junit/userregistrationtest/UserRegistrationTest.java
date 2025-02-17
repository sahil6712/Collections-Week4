package junit.userregistrationtest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.userregistration.UserRegistration;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully",
                UserRegistration.registerUser("JohnDoe", "johndoe@example.com", "Password123"),
                "Valid registration should succeed");
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("", "user@example.com", "Password123"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("JohnDoe", "invalid-email", "Password123"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("JohnDoe", "johndoe@example.com", "short"));
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    void testNullValues() {
        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser(null, "johndoe@example.com", "Password123"));

    }
}
