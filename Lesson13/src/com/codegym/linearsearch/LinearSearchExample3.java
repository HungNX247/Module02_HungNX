package com.codegym.linearsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearchExample3 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.print("Enter number of elements in array: ");
        Integer n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        inputNumbers(numbers, n);

        System.out.print("Please enter number want to find: ");
        Integer findingNumber = scanner.nextInt();

        List<Integer> result = linearSearch(numbers, findingNumber);
        if (result.isEmpty())
            System.out.print("Element is not present in array");
        else {
            for (Integer index: result) {
                System.out.println("Element is present at index: " + index);
            }
        }  
    }

    private static void inputNumbers(List<Integer> numbers, Integer n) {
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at index " + i + ": ");
            Integer inputNumber = scanner.nextInt();
            numbers.add(inputNumber);
        }
    }

    public static List<Integer> linearSearch(List<Integer> numbers, Integer findingNumber) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(findingNumber)) {
                positions.add(i);
            }
        }
        return positions;
    }
}
