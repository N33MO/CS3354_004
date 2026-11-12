package Module5.solid.srp;

public class Demo3 {
    
}

/**
 * Employee computes salary and also generates a formatted report — two 
 * concerns that evolve on completely different schedules.
 */

// BEFORE
class Employee {

  public double calculatePay() {
    return hoursWorked * hourlyRate;
  }

  public String generateReport() {
    return "Name: " + name
      + ", Pay: " + calculatePay();
  }

}

// AFTER
class Employee {
  public double calculatePay() {
    return hoursWorked * hourlyRate;
  }
}

class EmployeeReporter {
  public String generateReport(
      Employee e) {
    return "Name: " + e.getName()
      + ", Pay: " + e.calculatePay();
  }
}

