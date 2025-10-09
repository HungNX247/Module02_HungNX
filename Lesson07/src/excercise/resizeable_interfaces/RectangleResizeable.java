package excercise.resizeable_interfaces;

public class RectangleResizeable {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(10.2, 5.6);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(5.8, 6.2, "blue", false);

        System.out.println("Before the change:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
        System.out.println();

        System.out.println("After the change:");
        double percent = Math.random() * 99 + 1;
        System.out.println("Resize with ratio: " + String.format("%.2f", percent) + "%");
        for (Rectangle rectangle : rectangles) {
            ((Resizeable) rectangle).resize(percent);
            System.out.println(rectangle);
        }
    }
}
