package com.codegym.io_binary_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteBinaryFileExample {
    public static void main(String[] args) {
        String filePath = "F:\\codegym\\module-02-advanced-programming-with-java\\sources\\lesson-16-17-io-file-handling\\src\\com\\codegym\\file_data\\employees.dat";
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("E001", "Dao Nguyen", 2500));
        employees.add(new Employee("E002", "Minh Tran", 2300));
        employees.add(new Employee("E003", "Thu Le", 1800));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            System.out.println("Binary file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
