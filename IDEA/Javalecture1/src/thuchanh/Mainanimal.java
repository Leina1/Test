package thuchanh;

public class Mainanimal {
    public static void main(String[] args) {
        animal dog = new Dog();
        animal cat = new Cat();

        dog.eat();
        dog.makeSound();
        dog.sleep();

        cat.eat();
        cat.makeSound();
        cat.sleep();
    }
}
