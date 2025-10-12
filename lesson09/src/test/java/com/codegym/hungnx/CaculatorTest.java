package com.codegym.hungnx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CaculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testDivine() {
        int result = calculator.divide(6, 3);
        assertEquals(3, result);
    }

}
