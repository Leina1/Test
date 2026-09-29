package thuchanh;

public class Dog extends animal{
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }

}
