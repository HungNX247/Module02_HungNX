package comparable_interface;

public class Student implements Comparable<Student> {
    String name;
    int age;
    double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return name + " - " + age + " - " + score;
    }
}
