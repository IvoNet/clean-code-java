package nl.ivonet;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountService {


    public BigDecimal applyDiscount(final BigDecimal amount, Discount discount) {

        discount = discount == null ? new NoneDiscount() : discount;

        return discount.apply(amount).setScale(2, RoundingMode.HALF_EVEN);
    }

}
