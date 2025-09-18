import java.util.Scanner;

public class GreatestCommonFactor {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a, b;
        System.out.print("Enter a: ");
        a = sc.nextInt();
        System.out.print("Enter b: ");
        b = sc.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No greatst common factor");
            return;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("Greatest common factor: " + a);
    }
}
