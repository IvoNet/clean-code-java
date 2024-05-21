package nl.ivonet;

import java.math.BigDecimal;

public class NoneDiscount implements Discount {
    @Override
    public BigDecimal apply(final BigDecimal amount) {
        return amount;
    }
}
