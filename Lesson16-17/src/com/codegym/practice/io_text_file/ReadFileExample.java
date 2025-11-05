package com.codegym.practice.io_text_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    private static final Scanner scanner = new Scanner(System.in);

    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line = "";
            int sum = 0;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println("Sum: " + sum);

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("File khong ton tai hoac khong hop le!");
        }
    }

    public static void main(String[] args) {
        System.out.print("Nhap duong dan file: ");
        String path = scanner.nextLine();

        ReadFileExample readFileExample = new ReadFileExample();

        readFileExample.readFileText(path);
    }
}
