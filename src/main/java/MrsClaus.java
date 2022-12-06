import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MrsClaus
{
    Sleigh sleigh;
    private ExecutorService executorService;


    public MrsClaus(int numberOfElves, Sleigh sleigh)
    {
        executorService = Executors.newFixedThreadPool(numberOfElves);
        this.sleigh = sleigh;

    }
    public void receivePresent(Present present)
    {
        Runnable task = () -> {
            Elf elf = new Elf(sleigh);
            try
            {
                elf.receivePresent(present);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        };
        executorService.submit(task);

    }
}
