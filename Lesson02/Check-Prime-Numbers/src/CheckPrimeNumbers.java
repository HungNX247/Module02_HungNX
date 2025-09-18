import java.util.Scanner;

public class CheckPrimeNumbers {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a numner: ");
        int numner = sc.nextInt();
        if (numner < 2) {
            System.out.println(numner + " is not a prime number");
        } else {
            int i = 2;
            boolean isPrime = true;
            while (i <= Math.sqrt(numner)) {
                if (numner % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
            if (isPrime) {
                System.out.println(numner + " is a prime number");
            } else {
                System.out.println(numner + " is not a prime number");
            }
        }
    }
}
