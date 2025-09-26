import java.util.Scanner;

public class QuadraticEquation {
    private static Scanner sc = new Scanner(System.in);
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (b * b - 4 * a * c);
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(delta)) / (2 * a);
    }

    public static void main(String[] args) {
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();
        if (delta > 0) {
            System.out.println("The equation has two solutions: ");
            System.out.println("x1 = " + equation.getRoot1());
            System.out.println("x2 = " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("Equations with double roots: x1 = " + equation.getRoot1());
        } else {
            System.out.println("The equation has no solution!");
        }

        sc.close();
    }
}
