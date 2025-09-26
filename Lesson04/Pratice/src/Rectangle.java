import java.util.Scanner;

public class Rectangle {
    private static Scanner sc = new Scanner(System.in);
    double width, height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle {" + " width = " + width + ", height = " + height + "}";
    }

    public static void main(String[] args) {
        System.out.print("Enter the width: ");
        double width = sc.nextDouble();
        System.out.print("Enter the height: ");
        double height = sc.nextDouble();

        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n" + rectangle.display());
        System.out.print("Perimeter of the Rectangle: " + rectangle.getPerimeter());
        System.out.println();
        System.out.print("Area of the Rectangle: " + rectangle.getArea());

        sc.close();
    }
}
