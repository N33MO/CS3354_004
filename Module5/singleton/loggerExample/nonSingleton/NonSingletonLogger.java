package Module5.singleton.loggerExample.nonSingleton;

/**
 * An ordinary class: every "new" produces another logger.
 *
 * The instance id below exists only to make that visible in the output.
 * Compare with the singleton version in the sibling package.
 */
public class NonSingletonLogger {
    private static int instancesCreated = 0;
    private final int id;

    public NonSingletonLogger() {
        id = ++instancesCreated;
        System.out.println("(constructed logger instance #" + id + ")");
    }

    public void log(String message) {
        System.out.println("[LOG #" + id + "] " + message);
    }
}
