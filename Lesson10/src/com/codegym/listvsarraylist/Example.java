package com.codegym.listvsarraylist;

import java.util.*;

public class Example {

    public static void main(String[] args) {
        List<Student> studentsA = new ArrayList<>();
        studentsA.add(new Student(1, "Nhân"));
        studentsA.add(new Student(2, "Thịnh"));
        studentsA.add(new Student(3, "Kiệt"));
        System.out.println(studentsA);

        List<Student> studentsB = new LinkedList<>(studentsA);
        System.out.println(studentsB);
    }
}
