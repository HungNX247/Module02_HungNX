package com.codegym.generic.generic_interface;

public class EmployeeObjImpl implements IGeneralObj<Employee> {

    @Override
    public String sayHello(Employee employee) {
        return "Hello: " + employee;
    }
}
