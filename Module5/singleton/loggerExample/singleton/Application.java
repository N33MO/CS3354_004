package Module5.singleton.loggerExample.singleton;

/**
 * Deliberately the same shape as the nonSingleton Application: two parts of
 * the application each ask for a logger. Only the output differs.
 */
public class Application {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Message from part of the application");

        Logger logger2 = Logger.getInstance();
        logger2.log("Message from another part of the application");

        System.out.println("Same object? " + (logger1 == logger2));
    }
}
