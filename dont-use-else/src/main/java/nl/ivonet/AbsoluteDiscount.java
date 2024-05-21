package nl.ivonet;

import java.math.BigDecimal;

public class AbsoluteDiscount implements Discount {
    private final BigDecimal discount;

    public AbsoluteDiscount(final BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal apply(final BigDecimal amount) {
        final BigDecimal reduceAmount;
        if (this.discount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("An absolute discount should be positive");
        }
        reduceAmount = amount.subtract(this.discount);
        return reduceAmount;
    }
}
