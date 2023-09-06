import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);     //declaring initial and final price
        System.out.printf("%.2f", stock.getChangePercent());                    //display price change percentage
        System.out.print("%" + "\n");
    }
}
