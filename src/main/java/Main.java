import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Predicate<Integer> p = i -> i % 2 == 0;
//        System.out.println(p.test(2));
//        BankAccount ba1 = new BankAccount("3", 1000);
//        BankAccount ba2 = new BankAccount("4", 1000);
//        serialize(List.of(ba1, ba2), "account.dat");

      List<BankAccount> ba = deserialize("account.dat");



       System.out.println(ba);


    }

    public static void serialize(List<BankAccount> accounts, String fileName) throws IOException
    {
        try(ObjectOutputStream outputStream =  new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName))))
        {
            for (BankAccount account: accounts)
              outputStream.writeObject(account);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static List<BankAccount> deserialize(String fileName) throws IOException
    {
        List<BankAccount> list = new ArrayList<>();
        try(ObjectInputStream inputStream =  new ObjectInputStream(Files.newInputStream(Paths.get(fileName))))
        {
            BankAccount account = null;
            while ((account = (BankAccount) inputStream.readObject()) != null)
            {
                list.add(account);
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return list;

    }
}
