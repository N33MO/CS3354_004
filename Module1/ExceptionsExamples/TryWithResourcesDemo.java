/**
 * Title: Java Try-With-Resources Example
 *
 * From:
 *  - M1-3:Basic Java Programming
 *
 * Problem statement:
 * This example shows how Java try-with-resources works:
 *  Part 1 - MaskedExceptionDemo rewritten: resources are closed for us,
 *           so no NullPointerException hides the real error.
 *  Part 2 - Resources are closed automatically, in REVERSE order,
 *           BEFORE the catch and finally blocks run.
 *  Part 3 - If close() also throws, the original exception is kept and
 *           the close() exception is attached as a "suppressed" exception.
 *
 * Run from the repository root (so inputDemo.txt can be found):
 *  javac Module1/ExceptionsExamples/TryWithResourcesDemo.java
 *  java Module1.ExceptionsExamples.TryWithResourcesDemo
 *
 * @date 2026-09-28
 */

package Module1.ExceptionsExamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Any class that implements AutoCloseable can be used in try-with-resources.
class DemoResource implements AutoCloseable {
    private final String name;
    private final boolean failOnClose;

    public DemoResource(String name, boolean failOnClose) {
        this.name = name;
        this.failOnClose = failOnClose;
        System.out.println("  open  " + name);
    }

    public void use() {
        System.out.println("  use   " + name);
    }

    @Override
    public void close() {
        System.out.println("  close " + name);
        if (failOnClose) {
            throw new IllegalStateException("close() failed for " + name);
        }
    }
}

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        part1FixMaskedException();
        part2CloseOrder();
        part3SuppressedException();
    }

    // Part 1: same logic as MaskedExceptionDemo, but no finally block needed.
    public static void part1FixMaskedException() {
        System.out.println("=== Part 1: Fixing MaskedExceptionDemo ===");
        // Resources declared inside ( ) are closed automatically, and only
        // if they were successfully opened -- so no null checks are needed.
        try (Scanner sc = new Scanner(new File("inputDemo.txt"));
             PrintWriter pw = new PrintWriter("output.txt")) {
            int num = sc.nextInt(); // 5
            int den = sc.nextInt(); // 0
            int val = num / den;
            System.out.println("Val: " + val);
            pw.println("result = " + val);
        } catch (FileNotFoundException e) {
            System.out.println("File problem: " + e.getMessage());
        } catch (ArithmeticException e) {
            // We see the REAL error, not a NullPointerException from close().
            System.out.println("Math problem: " + e.getMessage());
        }
        System.out.println();
    }

    // Part 2: watch the order of open / use / close / catch / finally.
    public static void part2CloseOrder() {
        System.out.println("=== Part 2: Close order ===");
        try (DemoResource first = new DemoResource("first", false);
             DemoResource second = new DemoResource("second", false)) {
            first.use();
            second.use();
            throw new RuntimeException("problem in try block");
        } catch (RuntimeException e) {
            // Both resources are already closed when we get here.
            System.out.println("  catch: " + e.getMessage());
        } finally {
            System.out.println("  finally runs last");
        }
        System.out.println();
    }

    // Part 3: compare with FinallyBlockMaskException -- nothing is lost here.
    public static void part3SuppressedException() {
        System.out.println("=== Part 3: Suppressed exceptions ===");
        try (DemoResource r = new DemoResource("fragile", true)) {
            r.use();
            throw new RuntimeException("Original from try block.");
        } catch (RuntimeException e) {
            System.out.println("  caught:     " + e.getMessage());
            for (Throwable s : e.getSuppressed()) {
                System.out.println("  suppressed: " + s.getMessage());
            }
        }
    }
}
