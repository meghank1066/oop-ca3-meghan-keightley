
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;
/**
 *  Name: Meghan Keightley
 *  Class Group: SD2A
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
        //to keep track of the blocks of shares
        Queue<Block> stocksOwned = new LinkedList<>();
        double totalProfit = 0;

        String command="";

        System.out.println("Commands: Please enter buy, sell, or quit.");

        do {
            System.out.print("Enter command: ");
            System.out.print(">");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                System.out.print("enter quantity and price: ");
                int buyqty = in.nextInt();
                double buyprice = in.nextDouble();
                stocksOwned.add(new Block(buyqty, buyprice));
            } else if (command.equals("sell")) {
                System.out.print("enter quantity and price: ");
                int sellqty = in.nextInt();
                double sellingprice = in.nextDouble();

                while (!stocksOwned.isEmpty() && sellqty > 0) {
                    Block firstblock = stocksOwned.peek();
                    int currentqty = firstblock.getQty();
                    double buyprice = firstblock.getPrice();
                    double saleprofit = 0;

                    if (sellqty >= currentqty) {
                        saleprofit = currentqty * (sellingprice - buyprice);
                        totalProfit += saleprofit;
                        sellqty -= currentqty;
                        stocksOwned.poll();
                        System.out.println("sold " + currentqty + " from first batch at " + sellingprice +
                                " for a profit: " + saleprofit);
                    } else {
                        saleprofit = sellqty * (sellingprice - buyprice);
                        totalProfit += saleprofit;
                        firstblock.setQty(currentqty - sellqty);
                        System.out.println("Sold " + sellqty + " from second batch at " + sellingprice +
                                " for a profit: " + saleprofit);
                        sellqty = 0;
                    }
                }
            } else if (!command.equalsIgnoreCase("quit")) {
                System.out.println("Invalid command. Please enter buy, sell, or quit.");
            }

        } while (!command.equalsIgnoreCase("quit"));

        System.out.println("Total profit: " + totalProfit);
    }
}