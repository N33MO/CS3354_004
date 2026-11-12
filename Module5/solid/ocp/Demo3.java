package Module5.solid.ocp;

public class Demo3 {
    
}


/**
 * Logger decides where to write output using an if/else chain. Every 
 * new output destination means reopening and editing the Logger class.
 */

// BEFORE
class Logger {
  public void log(
      String message, String type) {
    if (type.equals("console")) {
      System.out.println(message);
    } else if (type.equals("file")) {
      // write to file...
    } else if (type.equals("database")) {
      // write to database...
    }
    // add Slack? edit this class.
  }
}

// AFTER
interface LogOutput {
  void write(String message);
}
class ConsoleOutput implements LogOutput {
  public void write(String message) {
    System.out.println(message);
  }
}
// SlackOutput, FileOutput — same pattern.
// Adding a new output = new class only.
class Logger {
  private LogOutput[] outputs;
  public Logger(LogOutput[] outputs) {
    this.outputs = outputs;
  }
  public void log(String message) {
    for (LogOutput o : outputs) {
      o.write(message);
    }
  }
}

