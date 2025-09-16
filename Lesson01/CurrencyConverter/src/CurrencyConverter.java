import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        double usd, vnd;
        double rate = 26380.50;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount in USD: ");
        usd = scanner.nextDouble();
        double conVertUSDToVND = usd * rate;
        System.out.printf("Amount in VND: %.2f\n", conVertUSDToVND);

        System.out.println("Enter amount in VND: ");
        vnd = scanner.nextDouble();
        double conVertVNDToUSD = vnd / rate;
        System.out.printf("Amount in USD: %.2f\n", conVertVNDToUSD);
        scanner.close();
    }
}
