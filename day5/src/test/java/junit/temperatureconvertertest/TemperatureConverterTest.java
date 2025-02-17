package junit.temperatureconvertertest;

import org.example.junit.temperatureconverter.TemperatureConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureConverterTest {

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.01, "0°C should be 32°F");
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.01, "32°F should be 0°C");

    }
}
