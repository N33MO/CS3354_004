package Module5.solid.lsp;

public class Demo4 {
    
}


/**
 * The class hierarchy below violates LSP. Given the design 
 * requirements, how would you refactor it?
 * 
 * 1. A Fish class needs to be added — it eats and swims, but cannot fly
 * or make sounds on land.
 * 
 * 2. A new AnimalTrainer class must be able to call fly() on flyable 
 * animals only.
 * 
 * 3. A Snake class will be added later — it can only eat and hiss; it 
 * does not fly.
 * 
 * 4. The system should make it impossible at compile time to call fly()
 * on a non-flying animal.
 */

// BEFORE
class Animal {
    public void eat()       { System.out.println("Eating..."); }
    public void makeSound() { System.out.println("..."); }
    public void fly()       { System.out.println("Flying..."); }
}

class Dog extends Animal {
    @Override
    public void makeSound() { System.out.println("Woof!"); }
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dogs can't fly!");
    }
}

class Parrot extends Animal {
    @Override
    public void makeSound() { System.out.println("Squawk!"); }
    @Override
    public void fly()       { System.out.println("Parrot flying..."); }
}

// AFTER
interface Eater { void eat(); }
interface SoundMaker { void makeSound(); }
interface Flyer { void fly(); }

class Dog implements Eater, SoundMaker {
  public void eat() { System.out.println("Eating..."); }
  public void makeSound() { System.out.println("Woof!"); }
}

class Parrot implements Eater, SoundMaker, Flyer {
  public void eat() { System.out.println("Eating..."); }
  public void makeSound() { System.out.println("Squawk!"); }
  public void fly() { System.out.println("Parrot flying..."); }
}

class Fish implements Eater {
  public void eat() { System.out.println("Eating..."); }
}

class AnimalTrainer {
  public void train(Flyer animal) {
    animal.fly();
    // Dog, Fish, Snake cannot be
    // passed here — compile error
  }
}