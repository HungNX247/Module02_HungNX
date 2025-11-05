package com.codegym.io_binary_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadBinaryFileExample {
    public static void main(String[] args) {
        String filePath = "F:\\codegym\\module-02-advanced-programming-with-java\\sources\\lesson-16-17-io-file-handling\\src\\com\\codegym\\file_data\\employees.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            employees.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
