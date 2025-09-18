import java.util.Scanner;

public class ShowType {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Top-left");
                    for (int i = 1; i <= 6; i++) {
                        for (int j = 1; j < i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    System.out.println("Top-right");
                    for (int i = 6; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 0; i < 7; i++) {
                        for (int j = i; j < 7; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k < i; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("No choice!");
                    System.exit(0);
                    break;
            }
        }
    }
}
