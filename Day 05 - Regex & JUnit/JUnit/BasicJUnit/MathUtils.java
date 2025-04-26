package Day3.JUnit.BasicJUnit;

public class MathUtils {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testDivideSuccess() {
        assertEquals(5, MathUtils.divide(10, 2));
    }

    @Test
    void testDivideByZeroException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(10, 0),
                "Expected ArithmeticException when dividing by zero");
    }
}