package Module1.JavaProgramExample;

/**
 * Demonstrates the very basics of constructors.
 *
 * <p>A <b>constructor</b> runs when you create an object using {@code new}.
 * Constructors usually set starting values for the object's fields.</p>
 *
 * <p>This example shows:</p>
 * <ul>
 *   <li>A <b>no-argument constructor</b> (default values)</li>
 *   <li>A <b>parameter constructor</b> (caller provides values)</li>
 * </ul>
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/JavaProgramExample/MyConstructorExample.java
 * java Module1.JavaProgramExample.MyConstructorExample
 * </pre>
 *
 * @date 2026-02-02
 */
public class MyConstructorExample {
    private String name;
    private String color;

    /**
     * No-argument constructor: sets default starting values.
     */
    public MyConstructorExample() {
        name = "Banana";
        color = "Yellow";
    }

    /**
     * Parameter constructor: the caller provides starting values.
     *
     * @param name  the name to store in this object
     * @param color the color to store in this object
     */
    public MyConstructorExample(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Gets the current name stored in this object.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name stored in this object.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current color stored in this object.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Changes the color stored in this object.
     *
     * @param color the new color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    public static void main(String[] args) {
        // IMPORTANT IDEA:
        // These fields are private:
        //   private String name;
        //   private String color;
        //
        // - Inside THIS class (MyConstructorExample), we can still read/write them directly.
        // - Outside this class (in a different .java file), you must use getters/setters.

        // Using the no-argument constructor (defaults):
        MyConstructorExample fruit1 = new MyConstructorExample();
        // Direct field access is allowed here because we are inside MyConstructorExample.
        System.out.println("fruit1.name  = " + fruit1.name);
        System.out.println("fruit1.color = " + fruit1.color);

        System.out.println();

        // Using the parameter constructor (custom values):
        MyConstructorExample fruit2 = new MyConstructorExample("Strawberry", "Red");
        System.out.println("fruit2.name  = " + fruit2.name);
        System.out.println("fruit2.color = " + fruit2.color);

        System.out.println();

        // Here we use setters (this is what other classes would do):
        fruit2.setName("newName");
        fruit2.setColor("newColor");
        System.out.println("fruit2 after setters:");
        System.out.println("fruit2.name  = " + fruit2.getName());
        System.out.println("fruit2.color = " + fruit2.getColor());
    }
}
