import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Present implements Comparable<Present>
{
    private final String family;
    private final String name;

    private UUID id = UUID.randomUUID();


    public Present(String family, String name)
    {
        this.family = family;
        this.name = name;
    }

    public String getFamily()
    {
        return family;
    }

    public String getName()
    {
        return name;
    }


    public UUID getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Present{" +
                "family='" + family + '\'' +
                '}';
    }


    @Override
    public int compareTo(Present o)
    {
        Comparator<Present> comparator = Comparator.comparing(Present::getFamily).thenComparing(Present::getId);
        return comparator.compare(this,o);
    }


}
