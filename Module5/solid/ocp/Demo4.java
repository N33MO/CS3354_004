package Module5.solid.ocp;

public class Demo4 {
    
}

/**
 * The class below violates OCP. Given the design requirements, how 
 * would you refactor it?
 * 
 * 1. A new "student" discount tier at 15% will be introduced next 
 * month.
 * 
 * 2. The VIP discount rate may be adjusted each quarter based on 
 * business decisions.
 * 
 * 3. Each discount type may eventually require its own eligibility 
 * validation logic.
 * 
 * 4. The marketing team plans to A/B test different discount strategies
 * at runtime.
 */

// BEFORE
class DiscountCalculator {

    public double calculate(String customerType, double price) {
        if (customerType.equals("regular")) {
            return price * 0.05;
        } else if (customerType.equals("premium")) {
            return price * 0.10;
        } else if (customerType.equals("vip")) {
            return price * 0.20;
        }
        return 0;
    }
}

// AFTER
interface DiscountStrategy {
  double calculate(double price);
}

class RegularDiscount implements DiscountStrategy {
  public double calculate(double price) {
    return price * 0.05;
  }
}

class VipDiscount implements DiscountStrategy {
  public double calculate(double price) {
    return price * 0.20; // only here
  }
}

class StudentDiscount implements DiscountStrategy {
  public double calculate(double price) {
    return price * 0.15;
  }
}

class DiscountCalculator {
  public double calculate(
      DiscountStrategy strategy,
      double price) {
    return strategy.calculate(price);
  }
}

// A/B test at runtime — no code change needed:
// new DiscountCalculator()
//   .calculate(new StudentDiscount(), price);
