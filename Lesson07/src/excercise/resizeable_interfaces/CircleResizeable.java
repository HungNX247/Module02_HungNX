package excercise.resizeable_interfaces;

public class CircleResizeable {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(10.2);
        circles[1] = new Circle();
        circles[2] = new Circle(5.8, "red", false);

        System.out.println("Before the change:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        System.out.println();

        System.out.println("After the change:");
        double percent = Math.random() * 99 + 1;
        System.out.println("Resize with ratio: " + String.format("%.2f", percent) + "%");
        for (Circle circle : circles) {
            ((Resizeable) circle).resize(percent);
            System.out.println(circle);
        }

    }
}
