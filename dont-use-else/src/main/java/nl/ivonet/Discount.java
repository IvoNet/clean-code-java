package nl.ivonet;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal apply(BigDecimal amount);
}
