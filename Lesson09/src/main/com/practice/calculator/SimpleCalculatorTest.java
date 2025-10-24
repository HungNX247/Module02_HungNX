import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {
    @Test
    @DisplayName("Testing add 0 + 0")
    public void testAdd0And0() {
        int first = 0;
        int second = 0;
        int expected = 0;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add 1 + 0")
    public void testAdd1And0() {
        int first = 1;
        int second = 0;
        int expected = 1;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add 0 + 1")
    public void testAdd0And1() {
        int first = 0;
        int second = 1;
        int expected = 1;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add 0 + 0")
    public void testAdd5And3() {
        int first = 5;
        int second = 3;
        int expected = 8;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing sub 0 - 0")
    public void testSub0and0() {
        int first = 0;
        int second = 0;
        int expected = 0;

        int result = SimpleCalculator.sub(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing sub 1 - 0")
    public void testSub1and0() {
        int first = 1;
        int second = 0;
        int expected = 1;

        int result = SimpleCalculator.sub(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing sub 0 - 1")
    public void testSub0and1() {
        int first = 0;
        int second = 1;
        int expected = -1;

        int result = SimpleCalculator.sub(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing sub 0 - 0")
    public void testSub5and3() {
        int first = 5;
        int second = 3;
        int expected = 2;

        int result = SimpleCalculator.sub(first, second);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing mutiply 2 * 3")
    void testMutiply2and3() {
        assertEquals(6, SimpleCalculator.mutiply(2, 3));
    }

    @Test
    @DisplayName("Testing divine 6 / 3")
    void testDivine6and3() {
        assertEquals(2, SimpleCalculator.divide(6, 3));
    }

    @Test
    @DisplayName("Testing divine 6 / 0")
    void testDivine6and0() {
        assertThrows(IllegalArgumentException.class, () -> SimpleCalculator.divide(6, 0));
    }
}
