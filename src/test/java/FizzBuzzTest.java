import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest
{
    @Test
    public void testCalculateMethodReturns1WhenInputIs1()
    {
        FizzBuzzCalculator sut = new FizzBuzzCalculator();
        String expected = "1";

        String actual = sut.calculate(1);

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({"2'",
                "4,'4'",
                "8,'8'",
                "7,'7'"})
    public void testCalculateMethodReturnsNumberWhenNotDivisibleByThreeOrFive(int input, String expected)
    {
        FizzBuzzCalculator sut = new FizzBuzzCalculator();

        String actual = sut.calculate(input);

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({"3,'FizzFizz'",
                "6,'Fizz'"})
    public void testCalculateMethodReturnsFizzWhenDivisibleByThree(int input, String expected)
    {
        FizzBuzzCalculator sut = new FizzBuzzCalculator();

        String actual = sut.calculate(input);

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({"5,'BuzzBuzz'",
            "10,'Buzz'"})
    public void testCalculateMethodReturnsBuzzWhenDivisibleByFive(int input, String expected)
    {
        FizzBuzzCalculator sut = new FizzBuzzCalculator();

        String actual = sut.calculate(input);

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({"15,'BuzzFizzBuzz'",
            "30,'FizzFizzBuzz'"})
    public void testCalculateMethodReturnsFizzBuzzWhenDivisibleByFiveAndThree(int input, String expected)
    {
        FizzBuzzCalculator sut = new FizzBuzzCalculator();

        String actual = sut.calculate(input);

        assertEquals(expected, actual);

    }

    @Test
    public void testHundredLinesGenerated()
    {
        NumberGenerator sut = new NumberGenerator(new FizzBuzzCalculator());
        int expected = 100;

        String result = sut.oneToHundred();
        int actual = result.split(System.lineSeparator()).length;

        System.out.println(result);
        assertEquals(expected,actual);

    }

    @Test
    public void numberContainsFiveButIsNotDivisibleByThreeOrFive() {
        //58
        FizzBuzzCalculator sut = new FizzBuzzCalculator();

        String actual = sut.calculate(58);

        assertEquals("Buzz", actual);
    }

    @Test
    public void numberContainsThreeButIsNotDivisibleByThreeOrFive() {
        //58
        FizzBuzzCalculator sut = new FizzBuzzCalculator();

        String actual = sut.calculate(13);

        assertEquals("Fizz", actual);
    }

    


}
