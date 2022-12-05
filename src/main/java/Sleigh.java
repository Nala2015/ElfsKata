import java.util.ArrayList;
import java.util.List;

public class Sleigh
{
    private List<String> presents;

    public Sleigh()
    {
        presents = new ArrayList<>();
    }

    public void addPresent(String present)
    {
        presents.add(present);
    }

    public int countOfPresents()
    {
        return presents.size();
    }
}
