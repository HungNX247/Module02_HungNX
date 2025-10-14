package main.com.excercise.triangle;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TriangleClassCifierTest {
    @Test
    public void testEquilateralTriangle() {
        assertEquals("Equilateral Triangle", TriangleClassCifier.classifyTriangle(2, 2, 2));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("Isosceles Triangle", TriangleClassCifier.classifyTriangle(2, 2, 3));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("Scalene Triangle", TriangleClassCifier.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testNotTriangle() {
        assertEquals("Not a Triangle", TriangleClassCifier.classifyTriangle(8, 2, 3));
    }

    @Test
    public void testNotTriangle1() {
        assertEquals("Not a Triangle", TriangleClassCifier.classifyTriangle(-1, 2, 1));
    }

    @Test
    public void testNotTriangle2() {
        assertEquals("Not a Triangle", TriangleClassCifier.classifyTriangle(0, 1, 1));
    }

}
