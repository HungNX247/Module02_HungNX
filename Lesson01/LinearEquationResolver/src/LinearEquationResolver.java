import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double a = scanner.nextDouble();

        System.out.println("b: ");
        double b = scanner.nextDouble();

        System.out.println("c: ");
        double c = scanner.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("x = %.2f!\n", answer);
        } else {
            if (b == c) {
              System.out.println("The equation has infinitely many solutions.");  
            } else {
               System.out.println("Equation with no solution"); 
            }
        }
        scanner.close();
    }
}
