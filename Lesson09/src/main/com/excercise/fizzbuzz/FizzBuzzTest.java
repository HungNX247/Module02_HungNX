package main.com.excercise.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    void testFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(31));
    }

    @Test
    void testBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(50));
    }

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(35));
    }

    @Test
    void testReadNumber() {
        assertEquals("hai sau", FizzBuzz.fizzBuzz(26));
    }

    @Test
    void testSingleDigit() {
        assertEquals("mot", FizzBuzz.fizzBuzz(1));
    }

}
