package cloneable_interface;

public class Main {
    public static void main(String[] args) {
        try {
            Ex01 ex01 = new Ex01(1, "Bob");
            Ex01 copy = (Ex01) ex01.clone();

            System.out.println(ex01.getName());
            System.out.println(copy.getName());
            System.out.println(ex01 == copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
