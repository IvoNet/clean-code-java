package nl.ivonet;

import java.math.BigDecimal;

public class PercentageDiscount implements Discount {
    private final BigDecimal discount;

    public PercentageDiscount(final BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal apply(final BigDecimal amount) {
        final BigDecimal reduceAmount;
        if (this.discount.compareTo(BigDecimal.ZERO) < 0 || this.discount.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("A percentaqge discount should be between 0.0 and 1.0");
        }
        reduceAmount = amount.subtract(amount.multiply(this.discount));
        return reduceAmount;
    }
}
