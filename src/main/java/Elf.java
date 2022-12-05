import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Elf
{
    private Sleigh sleigh;


    public Elf(Sleigh sleigh){
        this.sleigh = sleigh;
    }

    public void receivePresent(String present) throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(150);
        System.out.println(LocalDateTime.now());
        sleigh.addPresent(present);
    }


}
