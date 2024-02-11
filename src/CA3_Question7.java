import java.util.*;
/**
 *  Name: Meghan Keightley
 *  Class Group: SD2A
 */
public class CA3_Question7 {
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        //to keep track of the blocks of shares
        Map<String, Queue<Share>> stocksOwnedMap = new HashMap<>();
        double totalprofit = 0;


        String command = "";
        do {
            System.out.print("Enter command: ");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                System.out.println("enter in format: symbol/qty/price");
                String symbol = in.next();
                int buyqty = in.nextInt();
                double buyprice = in.nextDouble();

                // creating a list of shares for the symbol
                Queue<Share> boughtshares = stocksOwnedMap.computeIfAbsent(symbol, k -> new LinkedList<>());

                boughtshares.add(new Share(buyqty, buyprice));


            } else if (command.equals("sell")) {
                System.out.println("enter in format: symbol/qty/price");
                String symbol = in.next();
                int sellqty = in.nextInt();
                double sellingprice = in.nextDouble();

                // Get or create a queue for the given symbol
                Queue<Share> boughtshares = stocksOwnedMap.get(symbol);

                if (boughtshares != null) {
                    int remainingsellqty = sellqty;
                    double totalsaleprofit = 0;

                    while (!boughtshares.isEmpty() && remainingsellqty > 0) {
                        Share firstshare = boughtshares.peek();
                        int currentqty = firstshare.getQuantity();
                        double buyprice = firstshare.getPrice();
                        double saleprofit = 0;

                        if (remainingsellqty >= currentqty) {
                            // Sell all shares in the current block
                            saleprofit = currentqty * (sellingprice - buyprice);
                            totalsaleprofit += saleprofit;
                            remainingsellqty -= currentqty;
                            boughtshares.poll();  // Remove the entire block of shares
                        } else {
                            // Sell part of the shares in the current block
                            saleprofit = remainingsellqty * (sellingprice - buyprice);
                            totalsaleprofit += saleprofit;
                            firstshare.setQuantity(currentqty - remainingsellqty);
                            remainingsellqty = 0;
                        }
                    }

                    System.out.println("sold " + sellqty + "   of shares " + symbol +
                            " at market price for a total profit: " + totalsaleprofit);
                    totalprofit += totalsaleprofit;
                } else {
                    System.out.println("no shares owned for symbol " + symbol);
                }
            
        }else if (!command.equalsIgnoreCase("quit")) {
                System.out.println("input is invalid. Please enter buy, sell, or quit.");
            }

        } while (!command.equalsIgnoreCase("quit"));

        System.out.println("Total profit: " + totalprofit);
    }

}