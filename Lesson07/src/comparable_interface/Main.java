package comparable_interface;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("Hung", 20, 8.0),
                new Student("An", 19, 9.2),
                new Student("Binh", 20, 7.5));
        System.out.println("Sắp xếp theo mặc định (theo điểm): ");
        Collections.sort(list);
        list.forEach(System.out::println);

        System.out.println("\n Sắp xếp theo tên:");
        Collections.sort(list, new NameComparator());
        list.forEach(System.out::println);
    }
}
