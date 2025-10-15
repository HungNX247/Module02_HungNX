package main.com.excercise.triangle;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleClassCifierTest {
    @Test
    @DisplayName("Equilateral Triangle")
    public void testEquilateralTriangle() {
        assertEquals("Equilateral Triangle", TriangleClassCifier.classifyTriangle(2, 2, 2));
    }

    @Test
    @DisplayName("Isosceles Triangle")
    public void testIsoscelesTriangle() {
        assertEquals("Isosceles Triangle", TriangleClassCifier.classifyTriangle(2, 2, 3));
    }

    @Test
    @DisplayName("Scalene Triangle")
    public void testScaleneTriangle() {
        assertEquals("Scalene Triangle", TriangleClassCifier.classifyTriangle(3, 4, 5));
    }

    @Test
    @DisplayName("Not a Triangle")
    public void testNotTriangle() {
        assertEquals("Not a Triangle", TriangleClassCifier.classifyTriangle(8, 2, 3));
    }

    @Test
    @DisplayName("Not a Triangle: Side < 0")
    public void testNotTriangleSideLessThan0() {
        assertEquals("Not a Triangle", TriangleClassCifier.classifyTriangle(-1, 2, 1));
    }

    @Test
    @DisplayName("Not a Triangle: Side = 0")
    public void testNotTriangleSideBy0() {
        assertEquals("Not a Triangle", TriangleClassCifier.classifyTriangle(0, 1, 1));
    }

}
