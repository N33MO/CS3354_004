package Module5.solid.dip;

public class Demo3 {
    
}


/**
 * Multiple high-level services all hardcode a dependency on FileLogger.
 * One change to the logger ripples upward through every service 
 * simultaneously.
 */

// BEFORE
class FileLogger {
  public void log(String message) {
    System.out.println("File: " + message);
  }
}

class PaymentService {
  private FileLogger logger = new FileLogger();
  public void processPayment(double amount) {
    logger.log("Payment: " + amount);
  }
}

class AuthService {
  private FileLogger logger = new FileLogger();
  public void login(String user) {
    logger.log("Login: " + user);
  }
}

// OrderService, ReportService...
// all tied to FileLogger in the same way


// AFTER
interface ILogger { void log(String message); }
class FileLogger implements ILogger {
  public void log(String message) {
    System.out.println("File: " + message);
  }
}
class CloudLogger implements ILogger {
  public void log(String message) {
    System.out.println("Cloud: " + message);
  }
}
class PaymentService {
  private ILogger logger;
  public PaymentService(ILogger logger) {
    this.logger = logger;
  }
  public void processPayment(double amount) {
    logger.log("Payment: " + amount);
  }
}

// Switch all services at once — zero
// service code touched
ILogger logger = new CloudLogger();
new PaymentService(logger);
new AuthService(logger);

