package com.codegym.comparable;

import java.lang.*;

class Employee implements Comparable<Employee> {
    private Integer id;
    private String name;
    private Integer age;

    public Employee(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "(" + id + "," + name + "," + age + ")";
    }


    @Override
    public int compareTo(Employee obj) {
        // if the string are not equal
        if (this.name.compareTo(obj.name) != 0) {
            return this.name.compareTo(obj.name);
        } else {
            // we compare int values
            // if the strings are equal
            return this.age - obj.age;
        }
    }
}