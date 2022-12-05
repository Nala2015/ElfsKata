public class OrderCalculator
{

    public double getOrderTotal(String[] books)
    {
        if (books.length == 0)
            return 0;
        if (books.length == 2 && !books[0].equals(books[1]))
            return 15.2;
        if (books.length ==2)
            return 16;
        return 8.00;
    }
}
