package com.codegym.generic.generic_interface;

public class StudentObjImpl implements IGeneralObj<Student> {
    @Override
    public String sayHello(Student student) {
        return "Hello: " + student;
    }
}
