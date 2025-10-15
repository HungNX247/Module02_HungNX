
public class SimpleCalculator {
    public static int add(int first, int second) {
        return first + second;
    }

    public static int sub(int first, int second) {
        return first - second;
    }

    public static int mutiply(int first, int second) {
        return first * second;
    }

    public static int divide(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException();
        }
        return first / second;
    }
}
