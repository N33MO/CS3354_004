package Module1.JavaProgramExample;

/**
 * A small example program that calculates a factorial.
 *
 * <p>The factorial of a non-negative integer \(n\) is:</p>
 *
 * <pre>
 * n! = n × (n - 1) × (n - 2) × ... × 2 × 1
 * 0! = 1
 * </pre>
 *
 * <p>This example uses a simple <b>recursive</b> method (a method that calls itself).</p>
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/JavaProgramExample/FactorialCalculator.java
 * java Module1.JavaProgramExample.FactorialCalculator
 * </pre>
 */
public class FactorialCalculator {

    /**
     * Calculates {@code n!} (factorial) for a non-negative integer {@code n}.
     *
     * <p><b>Examples</b>:</p>
     * <ul>
     *   <li>{@code calculateFactorial(0)} returns {@code 1}</li>
     *   <li>{@code calculateFactorial(5)} returns {@code 120}</li>
     * </ul>
     *
     * <p><b>Important</b>: This method assumes {@code n >= 0}. If you pass a negative number,
     * the recursion will never reach {@code 0} and the program may crash.</p>
     *
     * @param n a non-negative integer
     * @return the factorial value {@code n!}
     */
    public static long calculateFactorial(int n) {
        // Base cases: stop the recursion.
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive step: n! = n × (n - 1)!
        return n * calculateFactorial(n - 1);
    }

    /**
     * The main entry point of the program.
     *
     * <p>Edits to try:</p>
     * <ul>
     *   <li>Change {@code number} to another value (like {@code 0}, {@code 1}, {@code 10}).</li>
     * </ul>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Input number for which factorial will be calculated
        int number = 5;

        // Calculate factorial
        long factorial = calculateFactorial(number);

        // Display the result
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}