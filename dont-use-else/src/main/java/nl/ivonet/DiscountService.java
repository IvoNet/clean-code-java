package nl.ivonet;


import java.math.BigDecimal;

public class DiscountService {


    public BigDecimal applyDiscount(final BigDecimal amount, DiscountType discountType, final BigDecimal discount) {

        discountType = discountType == null ? DiscountType.NONE : discountType;

        final BigDecimal reduceAmount;

        switch (discountType) {
            case PERCENTAGE -> {
                if (discount.compareTo(BigDecimal.ZERO) < 0 || discount.compareTo(BigDecimal.ONE) > 0) {
                    throw new IllegalArgumentException("A percentaqge discount should be between 0.0 and 1.0");
                }
                reduceAmount = amount.subtract(amount.multiply(discount));
            }
            case ABSOLUTE -> {
                if (discount.compareTo(BigDecimal.ZERO) < 0) {
                    throw new IllegalArgumentException("An absolute discount should be positive");
                }
                reduceAmount = amount.subtract(discount);
            }
            default -> reduceAmount = amount;
        }
        return reduceAmount;
    }

}
