import java.util.Arrays;
import java.util.Scanner;

public class PotterKata
{
    public static double unit_price = 8.0;

    public double calculatePrice(int[] basket)
    {
        int numOfClusters = 0;
        Arrays.sort(basket);
        String[] clusters = new String[basket.length];
        for (int i = 0; i < basket.length; i++) // set the value of each String element in an array to ""
            clusters[i] = "";

        //iterating over books and adding each to the right cluster
        for (int book : basket) {
            int clusterToAdd = 0;
            double min = unit_price;

            for (int j = 0; j < numOfClusters; j++) //iterating over clusters to find the place for the book
                if (!clusters[j].contains(Integer.toString(book)) && (price(clusters[j] + "i") - price(clusters[j])) < min)
                    min = price(clusters[j] + "i") - price(clusters[clusterToAdd = j]);

            if (min == unit_price)
                clusters[numOfClusters++] += book;
            else
                clusters[clusterToAdd] += book;
        }

        return Arrays.stream(clusters)
                .mapToDouble(PotterKata::price)
                .sum();
    }


    public static double price(String s)
    {
        if (s.length() == 0) return 0;
        else if (s.length() == 1) return 8;
        else if (s.length() == 2) return 15.2;
        else if (s.length() == 3) return 21.6;
        else if (s.length() == 4) return 25.6;
        else if (s.length() == 5) return 32;
        else return 40;
    }


}
