package Module5.singleton.loggerExample.singleton;

/**
 * The same logger as the nonSingleton package, with the pattern applied:
 * a private constructor and one shared instance handed out by getInstance().
 *
 * The instance id exists only to make the difference visible in the output.
 * Run both Application classes and compare: this one constructs once.
 */
public class Logger {
    // The single instance of the logger
    private static Logger instance;

    private static int instancesCreated = 0;
    private final int id;

    // Private constructor to prevent instantiation
    private Logger() {
        id = ++instancesCreated;
        System.out.println("(constructed logger instance #" + id + ")");
    }

    // Public method to get the instance of the logger
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        // Here, we're simply printing the message to the console.
        // In a real-world scenario, you could extend this to write to log files, databases, etc.
        System.out.println("[LOG #" + id + "] " + message);
    }

    // ... Other logging methods like logError, logInfo, logDebug, etc., can be added here
}
