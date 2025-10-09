package practice.practice02;

import java.util.Arrays;

public class ComparableRectangleTest {
    public static void main(String[] args) {
        ComparableRectangle[] comparableRectangles = new ComparableRectangle[3];
        comparableRectangles[0] = new ComparableRectangle();
        comparableRectangles[1] = new ComparableRectangle(3.4, 5.2);
        comparableRectangles[2] = new ComparableRectangle(2, 5.2, "red", false);

        System.out.println("Pre-sorted: ");
        for (ComparableRectangle comparableRectangle : comparableRectangles) {
            System.out.println(comparableRectangle);
        }

        Arrays.sort(comparableRectangles);

        System.out.println("Affter-sorted: ");
        for (ComparableRectangle comparableRectangle : comparableRectangles) {
            System.out.println(comparableRectangle);
        }
    }
}
