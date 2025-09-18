import java.util.Scanner;

public class InterestCalculator {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double money;
        double rate;
        int months;
        System.out.print("Enter investment amount: ");
        money = sc.nextDouble();
        System.out.print("Enter number of months: ");
        months = sc.nextInt();
        System.out.print("Enter annual interest rate in percentage: ");
        rate = sc.nextDouble();

        if (money < 0 || months < 0 || rate < 0) {
            System.out.println("Invalid input! Please enter non-negative values.");
            return;
        }

        double totalInterest = 0;
        for (int i = 0; i < months; i++) {
            totalInterest += money * (rate / 100) / 12 * months;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
