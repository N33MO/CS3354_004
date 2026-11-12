package Module5.solid.dip;

public class Demo1 {
    
}

/**
 * OrderService creates an EmailNotification directly inside itself — 
 * locking the high-level business logic to one specific low-level 
 * implementation.
 */

// BEFORE
class EmailNotification {
  public void send(String message) {
    System.out.println("Email: " + message);
  }
}

// High-level module hardcodes a dependency on a low-level class
class OrderService {
  private EmailNotification notification = new EmailNotification(); // hardcoded

  public void placeOrder(String item) {
    System.out.println("Order: " + item);
    notification.send("Your order: " + item);
  }
}

// AFTER
interface INotification { void send(String message); }

class EmailNotification implements INotification {
  public void send(String message) {
    System.out.println("Email: " + message);
  }
}

class SmsNotification implements INotification {
  public void send(String message) {
    System.out.println("SMS: " + message);
  }
}

// Dependency injected — OrderService knows nothing about Email or SMS
class OrderService {
  private INotification notification;
  public OrderService(INotification n) {
    this.notification = n;
  }
  public void placeOrder(String item) {
    System.out.println("Order: " + item);
    notification.send("Your order: " + item);
  }
}

