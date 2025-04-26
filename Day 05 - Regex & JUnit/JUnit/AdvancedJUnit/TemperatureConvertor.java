package Day3.JUnit.AdvancedJUnit;

public class TemperatureConvertor {
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    TemperatureConverter temperatureConverter = new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, temperatureConverter.celsiusToFahrenheit(0.0), 0.001);
        assertEquals(212.0, temperatureConverter.celsiusToFahrenheit(100.0), 0.001);
        assertEquals(98.6, temperatureConverter.celsiusToFahrenheit(37.0), 0.001);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, temperatureConverter.fahrenheitToCelsius(32.0), 0.001);
        assertEquals(100.0, temperatureConverter.fahrenheitToCelsius(212.0), 0.001);
        assertEquals(37.0, temperatureConverter.fahrenheitToCelsius(98.6), 0.001);
    }
}
