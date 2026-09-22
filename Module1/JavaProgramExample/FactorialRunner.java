package Module1.JavaProgramExample;

/**
 * A simple runner program that uses {@link FactorialCalculator}.
 *
 * <p>This file is mainly for practicing Javadoc navigation in your IDE:
 * hover or Cmd/Ctrl-click {@link FactorialCalculator} or
 * {@link FactorialCalculator#calculateFactorial(int)}.</p>
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/JavaProgramExample/FactorialRunner.java Module1/JavaProgramExample/FactorialCalculator.java
 * java Module1.JavaProgramExample.FactorialRunner
 * </pre>
 */
public class FactorialRunner {
    public static void main(String[] args) {
        int n = 5;
        long result = FactorialCalculator.calculateFactorial(n);
        System.out.println(n + "! = " + result);

        // Try changing n (0, 1, 10, ...)
    }
}

