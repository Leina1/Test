package thuchanh;

public class HighStudent extends Student{
    String major;

    public HighStudent(String name, int age, String SchoolName, String major) {
        super(name, age, SchoolName);
        this.major = major;
        System.out.println("HighStudent constructor called");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + major);
    }
}
