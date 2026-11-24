package module6.assertions;

public class HelloWorld {

    /**
     * Returns the greeting instead of printing it.
     *
     * Logic buried inside main() cannot be asserted on -- a test has no way to
     * call it or read what it produced. Returning the value makes it testable,
     * and main() just prints whatever this gives back.
     */
    public String greet() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().greet());
    }
}
