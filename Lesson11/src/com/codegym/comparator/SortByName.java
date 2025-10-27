package com.codegym.comparator;

import java.util.Comparator;

public class SortByName implements Comparator<Student> {

    // Sorting in ascending order of name
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}
