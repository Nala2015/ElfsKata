import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PotterKataTest
{
    PotterKata uut = new PotterKata();

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testingCalculateMethodWithOneBook(int book)
    {
        double expectedValue = 8.0;
        int[] basket = {book};


        double actualValue = uut.calculatePrice(basket);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testingCalculateMethodWithTwoDifferentBooks()
    {
        double expectedValue = 32;
        int[] basket = {1,2,3,4,5};

        double actualValue = uut.calculatePrice(basket);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testingCalculateMethodWithTwoIdenticalBooks()
    {
        double expectedValue = 16.00;
        int[] basket = {1,1};

        double actualValue = uut.calculatePrice(basket);

        assertEquals(expectedValue, actualValue);

    }

    @ParameterizedTest
    @CsvSource({"'12345', 32.0",
            "'1234', 25.6",
            "'123', 21.6",
            "'12', 15.2",
            "'1', 8.0"})
    public void testForRangeOfBasketsWithDifferentBooks(String books, double price)
    {
        double expectedValue = price;
        int[] basket = new int[books.length()];
        char[] chars = books.toCharArray();
        for (int i = 0; i < chars.length; i++)
            basket[i] = Character.getNumericValue(chars[i]);

        double actualValue = uut.calculatePrice(basket);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testTwoDicountsForFourBooks()
    {
        double expectedValue = 51.2;
        int[] books = {1,1,2,2,3,3,4,5};

        double actualValue = uut.calculatePrice(books);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testAnotherEdgeCaseSorted()
    {
        double expectedValue = 147.2;
        int[] books = {0,0,0,0,0,1,1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4};

        double actualValue = uut.calculatePrice(books);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testAnotherEdgeCaseUnsorted()
    {
        double expectedValue = 147.2;
        int[] books1 = {4,2,1,0,2,3,3,4,1,0,4,3,0,1,2,3,0,1,4,1,0,2,3};


        double actualValue = uut.calculatePrice(books1);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testAnotherEdgeCase()
    {
        double expectedValue = 189.6;
        int[] books1 = {0,0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,4,3,3};


        double actualValue = uut.calculatePrice(books1);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testEmptyBasket()
    {
        double expectedValue = 0;
        int[] books1 = {};


        double actualValue = uut.calculatePrice(books1);

        assertEquals(expectedValue, actualValue);

    }


}
