package Module1.JavaProgramExample;

public class FormattedOutputExample {
    public static void main(String[] args) {
        // Variables for demo
        int intVal = 42;
        double floatVal = 3.1415926535;
        String strVal = "Hello, Java!";


        System.out.printf("Integer:%4d%n", intVal);

        System.out.printf("Double: %.2f%n", floatVal);

        System.out.printf("Double: %7.2f%n", floatVal);

        System.out.printf("Double: %-7.2f%n", floatVal);

        System.out.printf("String: %s%n", strVal);
    }
}
