package Day3.JUnit.AdvancedJUnit;

public class Passwordvalidator {
    public boolean validate(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(passwordValidator.validate("Valid1Password"));
        assertTrue(passwordValidator.validate("MySecure1Pass"));
    }

    @Test
    void testInvalidPassword() {
        assertFalse(passwordValidator.validate("Short1"));
        assertFalse(passwordValidator.validate("nouppercase1"));
        assertFalse(passwordValidator.validate("NoDigitUppercase"));
        assertFalse(passwordValidator.validate(null));
    }
}