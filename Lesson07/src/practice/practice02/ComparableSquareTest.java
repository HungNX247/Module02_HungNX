package practice.practice02;

import java.util.Arrays;

public class ComparableSquareTest {
    public static void main(String[] args) {
        ComparableSquare[] comparableSquares = new ComparableSquare[3];
        comparableSquares[0] = new ComparableSquare(9.8);
        comparableSquares[1] = new ComparableSquare();
        comparableSquares[2] = new ComparableSquare(2.8, "blue", false);

        System.out.println("Pre-sorted:");
        for (ComparableSquare comparableSquare : comparableSquares) {
            System.out.println(comparableSquare);
        }

        Arrays.sort(comparableSquares);

        System.out.println("After-sorted:");
        for (ComparableSquare comparableSquare : comparableSquares) {
            System.out.println(comparableSquare);
        }
    }
}
