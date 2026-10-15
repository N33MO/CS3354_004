package Module2.DynamicPolymorphism.polymorphism;

import java.util.ArrayList;

public class Polymorphism {
    public static void main(String[] args) {
        // Animal myAnimal = new Animal();
        // myAnimal.makeSound();

        // myAnimal = new Dog();
        // myAnimal.makeSound();

        // myAnimal = new Cat();
        // myAnimal.makeSound();

        ArrayList<Animal> myArr = new ArrayList<>();
        myArr.add(new Animal());
        myArr.add(new Dog());
        myArr.add(new Cat());

        for (Animal e : myArr) {
            e.makeSound();
        }
    }
}

class Animal {
    private String type = "Generic Animal";
    
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    private String breed = "Labrador";
    
    public void wagTail() {
        System.out.println("A method defined in the dog class");
    }
    
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    private String color = "Orange";
    
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}