/**
 * Title: Java Exceptions Example - OutOfMemoryError
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions/error: OutOfMemoryError
 * Thia is an Error.
 * 
 * Why it occurs (in this code):
 * The infinite loop keeps allocating large int arrays and storing them in a 
 * list, eventually exhausting the JVM heap, causing OutOfMemoryError.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.Error;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorExample {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        while (true) list.add(new int[1_000_000]);
    }
}
