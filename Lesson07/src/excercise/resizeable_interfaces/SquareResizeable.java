package excercise.resizeable_interfaces;

public class SquareResizeable {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square();
        squares[1] = new Square(11.6);
        squares[2] = new Square(9.7, "gray", false);

        System.out.println("Before the change: ");
        for (Square square : squares) {
            System.out.println(square);
        }

        System.out.println();

        System.out.println("After the change: ");
        double percent = Math.random() * 99 + 1;
        System.out.println("Resize with ratio: " + String.format("%.2f", percent) + "%");
        for (Square square : squares) {
            ((Resizeable) square).resize(percent);
            System.out.println(square);
        }
    }
}
