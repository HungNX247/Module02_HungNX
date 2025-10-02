package excercise.moveablepoint;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(2.1f, 3.2f, 4.3f, 5.4f);
        System.out.println("Before move: " + moveablePoint);

        moveablePoint.move();
        System.out.println("After 1st move: " + moveablePoint);

        moveablePoint.move();
        System.out.println("After 2nd move: " + moveablePoint);
    }
}
