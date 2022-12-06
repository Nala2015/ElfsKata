import java.util.*;

public class Sleigh
{
    private SortedSet<Present> presents;

    public Sleigh()
    {
        presents = Collections.synchronizedSortedSet(new TreeSet<Present>());
    }

    public void addPresent(Present present)
    {
        presents.add(present);
    }

    public int countOfPresents()
    {
        return presents.size();
    }

    public SortedSet getPresents()
    {
        return presents;
    }

    public void removePresentsForFamily(String familyName)
    {
        presents.removeIf(p-> p.getFamily().equals(familyName));
    }
}
