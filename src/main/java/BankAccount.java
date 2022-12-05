import java.io.Serializable;

public class BankAccount implements Serializable
{
    private String id;
    private double balance;
    public BankAccount(String id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }
}
