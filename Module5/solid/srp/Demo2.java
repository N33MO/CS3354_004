package Module5.solid.srp;

public class Demo2 {
    
}

/**
 * Invoice mixes business logic (calculating the total) with 
 * presentation logic (deciding how to print it).
 */

// BEFORE
class Invoice {

  public double calculateTotal() {
    return items.stream()
      .mapToDouble(Item::getPrice)
      .sum();
  }

  public void printInvoice() {
    System.out.println(
      "Total: " + calculateTotal()
    );
  }
}

// AFTER
class Invoice {
  public double calculateTotal() {
    return items.stream()
      .mapToDouble(Item::getPrice)
      .sum();
  }
}

class InvoicePrinter {
  public void print(Invoice invoice) {
    System.out.println(
      "Total: " + invoice.calculateTotal()
    );
  }
}

