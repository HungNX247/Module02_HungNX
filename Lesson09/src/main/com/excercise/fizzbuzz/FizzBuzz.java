package main.com.excercise.fizzbuzz;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        if (number <= 0 || number >=100) {
            throw new IllegalArgumentException("Number must be beetwen 1 to 99");
        }
        String stringNumber = String.valueOf(number);
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        boolean contains3 = stringNumber.contains("3");
        boolean contains5 = stringNumber.contains("5");
        if ((isFizz || contains3) && (isBuzz || contains5))
            return "FizzBuzz";
        if (isFizz || contains3)
            return "Fizz";
        if (isBuzz || contains5)
            return "Buzz";
        return readNumberVietnamese(number);
    }

    private static String readNumberVietnamese(int number) {
        String[] arrayNumber = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};
        if (number < 10) return arrayNumber[number];

        int tens = number / 10;
        int ones = number % 10;

        return (arrayNumber[tens] +" " + arrayNumber[ones]).trim();
    }
}
