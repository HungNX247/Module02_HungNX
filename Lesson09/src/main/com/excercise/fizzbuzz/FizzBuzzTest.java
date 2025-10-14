package main.com.excercise.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    void testReadNumber() {
        assertEquals("hai sau", FizzBuzz.fizzBuzz(26));
    }
}
