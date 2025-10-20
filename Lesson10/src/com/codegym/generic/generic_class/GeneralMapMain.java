package com.codegym.generic.generic_class;

import java.util.HashMap;

public class GeneralMapMain {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap01 = new HashMap<>();
        hashMap01.put(1, "Nhân");
        hashMap01.put(2, "Sử");

        HashMap<String, String> hashMap02 = new HashMap<>();
        hashMap02.put("01", "Đạt");
        hashMap02.put("02", "Thịnh");

        GeneralMap<Integer, String> map01 = new GeneralMap<>();
        map01.addIntoMap(hashMap01, 3, "Kiệt Nhỏ");
        map01.addIntoMap(hashMap01, 4, "Kiệt Lớn");

        GeneralMap<String, String> map02 = new GeneralMap<>();
        map02.addIntoMap(hashMap02, "C06-001", "Bin");
        map02.addIntoMap(hashMap02, "C06-002", "Bo");

        System.out.println(hashMap01);
        System.out.println(hashMap02);
        System.out.println(map01.printMap(hashMap01));
        System.out.println(map02.printMap(hashMap02));

        map02.addIntoMap(hashMap01, "3", "Vinh Cheat");
        System.out.println(map01.printMap(hashMap01));

        map02.addIntoMap(hashMap02, "02", "Vinh Cheat");
        System.out.println(map02.printMap(hashMap02));

        map01.addIntoMap(hashMap01, 4, "Lượng");
        System.out.println(map01.printMap(hashMap01));
    }
}
