package Module3.generalization;

/**
 * GENERALIZATION  (hollow triangle, solid line:  Dog ----|> Animal)
 *
 * The "is-a" relationship: a subclass inherits from a superclass. In Java this
 * is the "extends" keyword, and it is the one relationship the language states
 * outright -- there is nothing to infer.
 *  - A Dog IS an Animal, so it inherits eat() without redeclaring it.
 *  - Dog adds bark(), which only Dogs have.
 *  - Because a Dog is an Animal, "Animal a = new Dog();" is legal. That
 *    substitutability is what inheritance buys you.
 *
 * Read the arrow as pointing from the specific to the general: the triangle
 * sits on the superclass end, at Animal.
 *
 * Note the contrast with "has-a": a Dog does not CONTAIN an Animal, it IS one.
 * See Module3.realization for the interface counterpart, drawn with the same
 * triangle but a dashed line.
 *
 * Run from the repository root:
 *   javac Module3/generalization/Generalization.java
 *   java Module3.generalization.Generalization
 */
class Animal {
    public void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Woof");
    }
}

public class Generalization {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();    // inherited from Animal -- Dog never declares it
        dog.bark();   // Dog's own addition

        // A Dog IS an Animal, so it can stand in wherever an Animal is wanted.
        // The variable's TYPE is Animal; the OBJECT is still a Dog.
        Animal asAnimal = new Dog();
        asAnimal.eat();

        // Uncomment to see the limit of that substitution: the compiler only
        // allows what the Animal type declares, and Animal has no bark().
        //    asAnimal.bark();   // error: cannot find symbol
        //
        // The object can still do it -- casting back proves the Dog is intact:
        ((Dog) asAnimal).bark();

        System.out.println("Is asAnimal really a Dog? " + (asAnimal instanceof Dog));
    }
}
