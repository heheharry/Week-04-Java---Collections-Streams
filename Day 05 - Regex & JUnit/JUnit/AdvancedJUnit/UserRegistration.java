package Day3.JUnit.AdvancedJUnit;

public class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }

        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address.");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    UserRegistration userRegistration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        try {
            userRegistration.registerUser("validUser", "user@example.com", "Valid1234");
        } catch (IllegalArgumentException e) {
            fail("Registration should succeed with valid input.");
        }
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "user@example.com", "Valid1234");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser(null, "user@example.com", "Valid1234");
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "invalid-email", "Valid1234");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "user@com", "Valid1234");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", null, "Valid1234");
        });
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "user@example.com", "short");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "user@example.com", null);
        });
    }
}
