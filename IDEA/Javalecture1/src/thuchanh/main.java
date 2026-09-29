package thuchanh;
public class main {
    public static void main(String[] args) {
        Student student1 = new Student("John", 20, "ABC School");
        student1.display();
        Student student2 = new Student("Alice", 22);
        student2.display();
        Student student3 = new HighStudent("Bob", 18, "XYZ School", "Science");
        student3.display();
    }
}
