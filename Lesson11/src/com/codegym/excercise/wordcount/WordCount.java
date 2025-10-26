package com.codegym.excercise.wordcount;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter string: ");
        String inputString = scanner.nextLine();

        Map<String, Integer> wordCountMap = new TreeMap<>();

        String[] words = inputString.toLowerCase().split(" ");

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n Tan suat hien thi: ");
        System.out.println("-------------------------------------------");
        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        scanner.close();
    }
    
}
