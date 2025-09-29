package com.codegym.hungnx.lesson05.excercise.student;

public class Student {
    private String name = "John";
    private String classes = "CO2";

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String nameString) {
        this.name = nameString;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classesString) {
        this.classes = classesString;
    }

    public String toString() {
        return "Name: " + name + ", Classes: " + classes;
    }
}
