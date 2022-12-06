import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChristmasDeliverTest
{
    @Test
    public void givenPresentEndsOnSleigh() throws InterruptedException
    {
        Sleigh sleigh = new Sleigh();
        MrsClaus mrsClaus = new MrsClaus(5, sleigh);
        ToyMachine sut = new ToyMachine(mrsClaus);

        int numberOfPresentsActuallyAdded = 20;
        for (int i = 0; i < numberOfPresentsActuallyAdded; i++)
            sut.givePresentToMrsClaus(new Present("Smith","Barbie"));
    

        Thread.sleep(10000);
        assertEquals(numberOfPresentsActuallyAdded, sleigh.countOfPresents());

    }

    @Test
    public void testThatPresentAreGroupedByFamily() throws InterruptedException
    {
        Sleigh sleigh = new Sleigh();
        MrsClaus mrsClaus = new MrsClaus(5, sleigh);
        ToyMachine sut = new ToyMachine(mrsClaus);

        int numberOfPresentsActuallyAdded = 24;
        for (int i = 0; i < 8 ; i++)
        {
            sut.givePresentToMrsClaus(new Present("Smith","Barbie"));
            sut.givePresentToMrsClaus(new Present("Jones","Barbie"));
            sut.givePresentToMrsClaus(new Present("Harris","Barbie"));

        }



        Thread.sleep(10000);
        System.out.println(sleigh.getPresents());


        boolean firstEightAreTheSame = areGroupedByFamilyName(sleigh,0,7);
        boolean secondEightAreTheSame = areGroupedByFamilyName(sleigh,8,15);
        boolean thirdEightAreTheSame = areGroupedByFamilyName(sleigh,16,23);


        assertTrue(firstEightAreTheSame && secondEightAreTheSame && thirdEightAreTheSame);


    }

    private static boolean areGroupedByFamilyName(Sleigh sleigh, int fromIndex, int toIndex)
    {

        List<Present> presents = new ArrayList<>(sleigh.getPresents());

        Present firstPresent = presents.get(fromIndex);


        return IntStream.range(fromIndex, toIndex)
                .mapToObj(p -> presents.get(p))
                .allMatch(p-> p.getFamily().equals(firstPresent.getFamily()));



    }

    @Test
    public void testThatPresentAreRemovedByFamily() throws InterruptedException
    {
        Sleigh sleigh = new Sleigh();
        MrsClaus mrsClaus = new MrsClaus(5, sleigh);
        ToyMachine sut = new ToyMachine(mrsClaus);

        int numberOfPresentsActuallyAdded = 24;
        for (int i = 0; i < 8 ; i++)
        {
            sut.givePresentToMrsClaus(new Present("Smith","Barbie"));
            sut.givePresentToMrsClaus(new Present("Jones","Barbie"));
            sut.givePresentToMrsClaus(new Present("Harris","Barbie"));

        }

        Thread.sleep(10000);

        sleigh.removePresentsForFamily("Smith");
        List<Present> presents = new ArrayList<>(sleigh.getPresents());


        assertTrue(presents.stream()
                .noneMatch(p-> p.getFamily().equals("Smith")));

    }


}
