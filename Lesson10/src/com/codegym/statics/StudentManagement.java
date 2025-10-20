package com.codegym.statics;

public class StudentManagement {

    public static void main(String[] args) {
        Student sA = new Student(1, "Tý");

        System.out.println(sA.getName());
        System.out.println(sA.SCHOOL_NAME);

//        System.out.println(Student.name);
        System.out.println(Student.SCHOOL_NAME);
    }
}
