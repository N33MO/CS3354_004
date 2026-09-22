package Module1.JavaProgramExample;

import java.time.LocalDate;

/**
 * A minimal "hello world" style program that prints a greeting and today's date.
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/JavaProgramExample/FirstExample.java
 * java Module1.JavaProgramExample.FirstExample
 * </pre>
 *
 * @date 2026-02-02
 */
public class FirstExample {
    public static void main(String[] args) {
        System.out.println("Hello, Java! Today's date is " + LocalDate.now());
    }
}
