package thuchanh;

public class Student {
    String name;
    int age;
    String SchoolName;

    public Student(String name, int age, String SchoolName) {
        this.name = name;
        this.age = age;
        this.SchoolName = SchoolName;
        System.out.println("Constructor with three parameters called");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.SchoolName = "ABC School"; // Default school name
        System.out.println("Constructor with two parameters called");
    }


    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("School Name: " + SchoolName);
    }

}
