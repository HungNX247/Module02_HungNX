package excercise.difficult_exercises;

import java.util.Scanner;

public class TestTriangle {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double side1, side2, side3;
        do {
            side1 = inputEdge("Enter edge 1: ");
            side2 = inputEdge("Enter edge 2: ");
            side3 = inputEdge("Enter edge 3: ");
            if (!isValidTriangle(side1, side2, side3)) {
                System.out.println("Error: 3 edge do not a valid triangle. Please re-enter!");
            }
        } while (!isValidTriangle(side1, side2, side3));

        System.out.print("Enter color: ");
        String color = sc.next();

        System.out.print("Is the triangle colored? (true/false): ");
        boolean filled = sc.nextBoolean();

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println("Triangular information: ");
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Fill: " + triangle.isFilled());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Describe: " + triangle.toString());

    }

    private static double inputEdge(String message) {
        double edge;
        do {
            System.out.println(message);
            while (!sc.hasNextDouble()) {
                System.out.println("Error: Number required!");
                sc.next();
                System.out.println(message);
            }
            edge = sc.nextDouble();
            if (edge <= 0) {
                System.out.println("Error: Edge is greater than 0!");
            }
        } while (edge <= 0);
        return edge;
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
