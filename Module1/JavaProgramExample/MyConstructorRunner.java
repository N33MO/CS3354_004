package Module1.JavaProgramExample;

/**
 * A simple "runner" program that uses {@link MyConstructorExample}.
 *
 * <p>This file exists so you can practice:</p>
 * <ul>
 *   <li>Creating an object with {@code new}</li>
 *   <li>Calling methods like {@code getName()}, {@code setName(...)} (getters/setters)</li>
 *   <li>Viewing Javadoc in your IDE (hover or Ctrl/Cmd-click {@link MyConstructorExample})</li>
 * </ul>
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/JavaProgramExample/MyConstructorRunner.java Module1/JavaProgramExample/MyConstructorExample.java
 * java Module1.JavaProgramExample.MyConstructorRunner
 * </pre>
 *
 * @date 2026-02-02
 */
public class MyConstructorRunner {
    public static void main(String[] args) {
        MyConstructorExample fruit = new MyConstructorExample();
        System.out.println("Default fruit:");
        System.out.println("  name  = " + fruit.getName());
        System.out.println("  color = " + fruit.getColor());

        System.out.println();

        fruit.setName("Apple");
        fruit.setColor("Green");
        System.out.println("After setters:");
        System.out.println("  name  = " + fruit.getName());
        System.out.println("  color = " + fruit.getColor());
    }
}

