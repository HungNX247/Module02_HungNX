package com.codegym.generic.generic_interface;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Tèo", "CodeGym-C10");
        StudentObjImpl sObj = new StudentObjImpl();
        System.out.println(sObj.sayHello(student));

        Employee employee = new Employee(1, "Tèo", "Backend Developer");
        EmployeeObjImpl eObj = new EmployeeObjImpl();
        System.out.println(eObj.sayHello(employee));
    }
}
