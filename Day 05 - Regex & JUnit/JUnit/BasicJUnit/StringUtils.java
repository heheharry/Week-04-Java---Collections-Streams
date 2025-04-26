package Day3.JUnit.BasicJUnit;

public class StringUtils {
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    public static String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("racecar", StringUtils.reverse("racecar"));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madonna") == false); // not palindrome
        assertTrue(StringUtils.isPalindrome("racecar")); // palindrome
        assertTrue(StringUtils.isPalindrome("level"));   // palindrome
        assertFalse(StringUtils.isPalindrome(null));     // null input
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("JAVA", StringUtils.toUpperCase("java"));
        assertNull(StringUtils.toUpperCase(null));
    }
}