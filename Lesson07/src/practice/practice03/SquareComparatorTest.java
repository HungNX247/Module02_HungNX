package practice.practice03;

import java.util.Arrays;

public class SquareComparatorTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square(30.9);
        squares[1] = new Square();
        squares[2] = new Square(11.8, "green", false);

        System.out.println("Pre-sorted:");
        for (Square square : squares) {
            System.out.println(square);
        }

        SquareComparator squareComparator = new SquareComparator();
        Arrays.sort(squares, squareComparator);

        System.out.println("After sorted:");
        for (Square square : squares) {
            System.out.println(square);
        }
    }
}
