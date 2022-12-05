import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PotterKata2Test
{
    @Test
    public void anEmptyOrderReturnsZero()
    {
        OrderCalculator sut = new OrderCalculator();
        double expected = 0;

        double orderAmount = sut.getOrderTotal(new String[]{});

        assertEquals(expected,orderAmount);

    }

    @Test
    public void oneBookOrderReturnsUnitPrice()
    {
        OrderCalculator sut = new OrderCalculator();
        double expected = 8.00;

        double orderAmount = sut.getOrderTotal(new String[]{"One"});

        assertEquals(expected,orderAmount);

    }

    @Test
    public void twoDifferentBookGetFivePercDiscount()
    {
        OrderCalculator sut = new OrderCalculator();
        double expected = 15.20;

        double orderAmount = sut.getOrderTotal(new String[]{"One", "Two"});

        assertEquals(expected,orderAmount);
    }

    @Test
    public void twoOfTheSameBookPriced16()
    {
        OrderCalculator sut = new OrderCalculator();
        double expected = 16;

        double orderAmount = sut.getOrderTotal(new String[]{"One", "One"});

        assertEquals(expected,orderAmount);
    }

}
