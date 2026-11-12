package Module5.solid.lsp;

public class Demo5 {
    
}

/**
 * ShippingCalculator accepts any finite, positive weight. ExpressShippingCalculator
 * rejects weights below 1 kg — strengthening the parent's precondition.
 * A caller using the parent type can no longer calculate a fee for a
 * valid 0.5 kg package. Different prices are allowed; rejecting a valid
 * input breaks the contract.
 */

// BEFORE
class ShippingCalculator {
    // Contract: accept any finite weight > 0; return a non-negative fee.
    public double calculateFee(double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        return weightKg * 10;
    }
}

class ExpressShippingCalculator extends ShippingCalculator {
    @Override
    public double calculateFee(double weightKg) {
        if (weightKg < 1) {
            throw new IllegalArgumentException("Minimum weight: 1 kg");
        }
        return weightKg * 20;
    }
}

class ShippingProcessor {
    public void process(ShippingCalculator calculator) {
        // Valid for the parent, but throws with ExpressShippingCalculator.
        System.out.println(calculator.calculateFee(0.5));
    }
}

// AFTER
class ShippingCalculator {
    // Contract: accept any finite weight > 0; return a non-negative fee.
    public double calculateFee(double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        return weightKg * 10;
    }
}

class ExpressShippingCalculator extends ShippingCalculator {
    @Override
    public double calculateFee(double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        // Minimum billable weight, not a restriction on accepted packages.
        return Math.max(1, weightKg) * 20;
    }
}

class ShippingProcessor {
    public void process(ShippingCalculator calculator) {
        // Same caller: 5.0 for standard shipping, 20.0 for express shipping.
        // The prices may differ; both must accept this valid weight.
        System.out.println(calculator.calculateFee(0.5));
    }
}
