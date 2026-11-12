package Module5.solid.lsp;

public class Demo1 {
    
}

/**
 * Penguin extends Bird and inherits fly() — but cannot fulfill that 
 * promise. Passing a Penguin where a Bird is expected crashes the 
 * program.
 */

// BEFORE
class Bird {
  public void fly() { System.out.println("Flying..."); }
}

class Penguin extends Bird {
  @Override
  public void fly() {
    throw new UnsupportedOperationException(
      "Penguins can't fly!"
    );
  }
}

class BirdController {
  public void makeBirdFly(Bird bird) {
    bird.fly(); // runtime crash with Penguin
  }
}

// AFTER
interface Flyable {
  void fly();
}

class Bird {
  public void eat() { System.out.println("Eating..."); }
}

class Eagle extends Bird implements Flyable {
  public void fly() { System.out.println("Eagle soaring..."); }
}

class Penguin extends Bird {
  public void swim() { System.out.println("Penguin swimming..."); }
}

class BirdController {
  public void makeBirdFly(Flyable bird) {
    bird.fly(); // Penguin cannot be passed here
  }
}


