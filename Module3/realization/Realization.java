package Module3.realization;

/**
 * REALIZATION  (hollow triangle, DASHED line:  Circle - - -|> Drawable)
 *
 * A class promises to provide the behavior an interface declares. In Java this
 * is the "implements" keyword.
 *  - Drawable says WHAT must happen (draw()) but never how.
 *  - Circle and Square each supply their own HOW. The @Override annotation
 *    makes the compiler check they really are fulfilling the contract.
 *  - As with generalization, substitution works: "Drawable d = new Circle();"
 *    lets callers depend on the interface and stay ignorant of Circle.
 *
 * Realization vs generalization -- same triangle, different line:
 *   solid line  (extends)    inherit existing behavior from a superclass
 *   dashed line (implements) commit to behavior an interface only declares
 *
 * A class may realize many interfaces but generalize only one superclass.
 * Module2/Interfaces/GameCharacters shows why that matters: a character picks
 * up Flyable, Swimmable, or Teleportable independently of its base class.
 *
 * Run from the repository root:
 *   javac Module3/realization/Realization.java
 *   java Module3.realization.Realization
 */
interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Draw circle");
    }
}

class Square implements Drawable {
    @Override
    public void draw() {
        System.out.println("Draw square");
    }
}

public class Realization {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();

        // Program to the interface: this caller never needs to know which
        // shape it holds, only that whatever it holds can draw itself.
        Drawable shape = new Square();
        shape.draw();

        // The real payoff of realization -- one contract, many implementors,
        // handled uniformly. Adding a Triangle later would need no change here.
        Drawable[] shapes = { new Circle(), new Square() };
        System.out.println("\nDrawing every shape through the interface:");
        for (Drawable d : shapes) {
            d.draw();
        }
    }
}
