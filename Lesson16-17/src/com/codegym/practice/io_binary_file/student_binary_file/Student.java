package com.codegym.practice.io_binary_file.student_binary_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private int id;
    private String name;
    private String address;

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Hung", "Ha Noi"));
        students.add(new Student(2, "Hoa", "Hai Phong"));

        writeDataToFile("student.txt", students);

        List<Student> students2 = readDataFromFile("student.txt");

        for (Student student : students2) {
            System.out.println(student);
        }
    }

    private static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

}
