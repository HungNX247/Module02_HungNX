package excercise.circleandcylinder;

public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        circle = new Circle(5.2);
        System.out.println(circle);
        cylinder = new Cylinder(5.2, 5.8);
        System.out.println(cylinder);

        circle = new Circle(5.5, "red");
        System.out.println(circle);
        cylinder = new Cylinder(5.5, 6.2, "blue");
        System.out.println(cylinder);
    }
}
