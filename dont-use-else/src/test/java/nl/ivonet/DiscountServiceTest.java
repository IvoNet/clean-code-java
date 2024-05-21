package nl.ivonet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountServiceTest {

    private DiscountService sut;

    @BeforeEach
    void setUp() {
        this.sut = new DiscountService();
    }

    @Test
    void testPercentageDiscount() {
        //given
        final BigDecimal amount = BigDecimal.valueOf(100);
        final BigDecimal discount = BigDecimal.valueOf(0.2);

        //when
        final BigDecimal result = this.sut.applyDiscount(amount, DiscountType.PERCENTAGE, discount);

        //then
        assertThat(result).isEqualByComparingTo("80");
    }

    @Test
    void testWrongPercentage() {
        //given
        final BigDecimal amount = BigDecimal.valueOf(100);
        final BigDecimal discount = BigDecimal.valueOf(2);

        //when
        try {
            this.sut.applyDiscount(amount, DiscountType.PERCENTAGE, discount);
        } catch (final IllegalArgumentException e) {
            //then
            assertThat(e).hasMessage("A percentaqge discount should be between 0.0 and 1.0");
        }
    }

    @Test
    void testAbsoluteDiscount() {
        //given
        final BigDecimal amount = BigDecimal.valueOf(100);
        final BigDecimal discount = BigDecimal.valueOf(10);

        //when
        final BigDecimal result = this.sut.applyDiscount(amount, DiscountType.ABSOLUTE, discount);

        //then
        assertThat(result).isEqualByComparingTo("90");
    }

    @Test
    void testWrongAbsolute() {
        //given
        final BigDecimal amount = BigDecimal.valueOf(100);
        final BigDecimal discount = BigDecimal.valueOf(-10);

        //when
        try {
            this.sut.applyDiscount(amount, DiscountType.ABSOLUTE, discount);
        } catch (final IllegalArgumentException e) {
            //then
            assertThat(e).hasMessage("An absolute discount should be positive");
        }
    }

    @Test
    void testNoneDiscount() {
        //given
        final BigDecimal amount = BigDecimal.valueOf(100);

        //when
        final BigDecimal result = this.sut.applyDiscount(amount, DiscountType.NONE, BigDecimal.ZERO);

        //then
        assertThat(result).isEqualByComparingTo("100");
    }

    @Test
    void testNullDiscount() {
        //given
        final BigDecimal amount = BigDecimal.valueOf(100);

        //when
        final BigDecimal result = this.sut.applyDiscount(amount, null, BigDecimal.ZERO);

        //then
        assertThat(result).isEqualByComparingTo("100");
    }
}
