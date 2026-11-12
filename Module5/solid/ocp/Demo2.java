package Module5.solid.ocp;

public class Demo2 {
    
}

/**
 * AreaCalculator checks the type of each shape manually. Every new 
 * shape requires opening and modifying the calculator itself.
 */

// BEFORE
class AreaCalculator {
  public double calculate(Object shape) {
    if (shape instanceof Circle) {
      Circle c = (Circle) shape;
      return Math.PI * c.radius * c.radius;
    } else if (shape instanceof Rectangle) {
      Rectangle r = (Rectangle) shape;
      return r.width * r.height;
    }
    return 0; // Triangle? Edit this class.
  }
}

// AFTER
interface Shape {
  double calculateArea();
}
class Circle implements Shape {
  private double radius;
  public double calculateArea() {
    return Math.PI * radius * radius;
  }
}
class Rectangle implements Shape {
  private double width, height;
  public double calculateArea() {
    return width * height;
  }
}
class AreaCalculator {
  public double calculate(Shape shape) {
    return shape.calculateArea(); // never changes
  }
}

