package com.codegym.comparator;

import java.util.Comparator;

public class SortByRoll implements Comparator<Student> {

    // Sorting in ascending order of roll number
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}
