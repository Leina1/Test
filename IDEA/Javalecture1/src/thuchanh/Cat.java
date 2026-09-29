package thuchanh;

public class Cat extends animal{

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping");
    }
}
