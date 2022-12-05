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


    public MrsClaus(int numberOfElfs, Sleigh sleigh)
    {
        executorService = Executors.newFixedThreadPool(numberOfElfs);
        this.sleigh = sleigh;

    }
    public void receivePresent(String toy)
    {
        Runnable task = () -> {
            Elf elf = new Elf(sleigh);
            try
            {
                elf.receivePresent(toy);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        };
        executorService.execute(task);

    }
}
