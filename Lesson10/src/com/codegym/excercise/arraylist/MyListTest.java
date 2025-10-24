package com.codegym.excercise.arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        list.add("Java");
        list.add("C++");
        list.add("Python");
        list.add("JavaScript");
        list.add(1, "C#");

        System.out.println("My List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("- " + list.get(i));
        }

        System.out.println("\nList contains 'Java'?" + " " + list.contains("Java"));

        list.remove(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("- " + list.get(i));
        }

        MyList<String> cloneList = list.clone();
        System.out.println("My clone list");
        for (int i = 0; i < cloneList.size(); i++) {
            System.out.println("- " + cloneList.get(i));
        }

        list.clear();
        System.out.println("After clear, size = " + list.size());
    }
}
