package Module5.solid.lsp;

public class Demo2 {
    
}

/**
 * Square extends Rectangle and overrides setWidth() and setHeight() — 
 * but secretly changes both dimensions at once, breaking the caller's 
 * reasonable assumptions.
 */

// BEFORE
class Rectangle {
  protected double width, height;

  public void setWidth(double w)  { this.width  = w; }
  public void setHeight(double h) { this.height = h; }
  public double calculateArea()   { return width * height; }
}

class Square extends Rectangle {
  @Override
  public void setWidth(double w) {
    this.width  = w;
    this.height = w; // silently changes height
  }
  @Override
  public void setHeight(double h) {
    this.width  = h;
    this.height = h; // silently changes width
  }
}

class ShapeProcessor {
  public void process(Rectangle r) {
    r.setWidth(5);
    r.setHeight(10);
    // expects 50, silently gets 100 with Square
    System.out.println(r.calculateArea());
  }
}

// AFTER
interface Shape {
  double calculateArea();
}

class Rectangle implements Shape {
  private double width, height;
  public Rectangle(double w, double h) {
    this.width = w; this.height = h;
  }
  public double calculateArea() {
    return width * height;
  }
}

class Square implements Shape {
  private double side;
  public Square(double side) {
    this.side = side;
  }
  public double calculateArea() {
    return side * side;
  }
}

class ShapeProcessor {
  public void process(Shape shape) {
    // always correct, no hidden surprises
    System.out.println(shape.calculateArea());
  }
}