package com.codegym.comparator;

public class Student {
    int rollno;
    String name, address;

    public Student(int rollno, String name, String address) {
        // This keyword refers to current instance itself
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        // Returning attributes of Student
        return this.rollno + " " + this.name + " " + this.address;
    }
}
