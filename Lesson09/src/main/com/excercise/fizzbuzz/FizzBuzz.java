package main.com.excercise.fizzbuzz;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz)
            return "FizzBuzz";
        if (isFizz)
            return "Fizz";
        if (isBuzz)
            return "Buzz";
        return String.valueOf(number);
    }
}
