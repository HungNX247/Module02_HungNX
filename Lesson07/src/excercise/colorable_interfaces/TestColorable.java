package excercise.colorable_interfaces;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.8);
        shapes[1] = new Rectangle(10.8, 9.2);
        shapes[2] = new Square(8.4);

        for (Shape shape : shapes) {
            System.out.println(shape);

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }

            System.out.println("-----------------------------------------------------");
        }
    }
}
