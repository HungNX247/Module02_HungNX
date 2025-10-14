package test.com.excercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.com.excercise.NextDayCalculator;

public class NextDayCalculatorTest {
    NextDayCalculator nextDayCalculator = new NextDayCalculator();

    @Test
    public void testNextDay_Normal() {
        assertEquals("02/01/2018", nextDayCalculator.getNextDay(1, 1, 2018));
    }

    @Test
    public void testNextDay_EndOfMonth() {
        assertEquals("01/02/2018", nextDayCalculator.getNextDay(31, 1, 2018));
    }

    @Test
    public void testNextDay_EndOfApril() {
        assertEquals("01/05/2018", nextDayCalculator.getNextDay(30, 4, 2018));
    }

    @Test
    public void testNextDay_NonLeapYear() {
        assertEquals("01/03/2018", nextDayCalculator.getNextDay(28, 2, 2018));
    }

    @Test
    public void testNextDay_LeapYear() {
        assertEquals("01/03/2020", nextDayCalculator.getNextDay(29, 2, 2020));
    }

    @Test
    public void testNextDay_EndOfYear() {
        assertEquals("01/01/2019", nextDayCalculator.getNextDay(31, 12, 2018));
    }

    @Test
    public void testNextDay_NonLeapDay() {
        assertEquals("29/02/2020", nextDayCalculator.getNextDay(28, 2, 2020));
    }
}
