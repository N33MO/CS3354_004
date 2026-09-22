package Module1.JavaProgramExample;

import java.util.ArrayList;

/**
 * Demonstrates basic usage of an {@link ArrayList} of {@link String}s by adding
 * a few items and printing the resulting list.
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/JavaProgramExample/MyArrayListExample.java
 * java Module1.JavaProgramExample.MyArrayListExample
 * </pre>
 *
 * @date 2026-02-02
 */
public class MyArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> myArrayList = new ArrayList<>();

        // Add elements to the ArrayList
        myArrayList.add("Apple");
        myArrayList.add("Banana");
        myArrayList.add("Strawberry");

        // Display the elements
        System.out.println("Elements in myArrayList: " + myArrayList);
    }
}
