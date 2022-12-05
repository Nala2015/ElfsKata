public class NumberGenerator
{

    private FizzBuzzCalculator fizzBuzzCalculator;
    public NumberGenerator(FizzBuzzCalculator fizzBuzzCalculator)
    {
        this.fizzBuzzCalculator = fizzBuzzCalculator;
    }

    public String oneToHundred()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 101; i++)
            sb.append(fizzBuzzCalculator.calculate(i)).append(System.lineSeparator());
        return sb.toString();
    }

}
