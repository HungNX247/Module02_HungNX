package comparable_interface;

import java.math.BigInteger;
import java.time.LocalDate;

public class Ex01 {
    public static void main(String[] args) {
        String[] cities = {"Savannah", "Boston", "Atlanta", "Tampa"};
        java.util.Arrays.sort(cities);
        for (String city : cities) {
            System.out.print(city + " ");
        }
        System.out.println();

        BigInteger[] hugeNumbers = {new BigInteger("2323231092923992"), new BigInteger("432232323239292"), new BigInteger("54623239292")};
        java.util.Arrays.sort(hugeNumbers);
        for (BigInteger bigInteger : hugeNumbers) {
            System.out.println(bigInteger + " ");
        }

        System.out.println(Integer.valueOf(3).compareTo(Integer.valueOf(5)));
        System.out.println("ABC".compareTo("ABE"));
        LocalDate date1 = LocalDate.of(2025, 1, 1);
        LocalDate date2 = LocalDate.of(2025, 10, 1);
        System.out.println(date1.compareTo(date2));
    }
}
