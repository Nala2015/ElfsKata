import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasDeliverTest
{
    @Test
    public void givenPresentEndsOnSleigh() throws InterruptedException
    {
        int numberOfElfs = 5;
        Sleigh sleigh = new Sleigh();
        MrsClaus mrsClaus = new MrsClaus(5, sleigh);
        ToyMachine sut = new ToyMachine(mrsClaus);

        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        sut.givePresentToMrsClaus("Barbie");
        int numberOfPresentsActuallyAdded = 20;

        Thread.sleep(10000);
        assertEquals(numberOfPresentsActuallyAdded, sleigh.countOfPresents());

    }
}
