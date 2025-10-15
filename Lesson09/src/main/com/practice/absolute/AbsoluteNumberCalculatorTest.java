package main.com.practice.absolute;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbsoluteNumberCalculatorTest {
    @Test
    @DisplayName("Absolute by 0")
    void testAbsoluteBy0() {
        int number = 0;
        int expected = 0;
        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Absolute by positive number")
    void testAbsolutePositiveNumber() {
        int number = 1;
        int expected = 1;
        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Absolute by negative number")
    void testAbsoluteNegativeNumber() {
        int number = -1;
        int expected = 1;
        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }
}
