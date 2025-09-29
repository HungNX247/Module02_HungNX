package com.codegym.hungnx.lesson05.excercise.student;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Hung");
        student1.setClasses("Java103");

        Student student2 = new Student();
        student2.setName("Viet");
        student2.setClasses("Java104");

        Student student3 = new Student();
        student3.getName();
        student3.getClasses();

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

    }
}
