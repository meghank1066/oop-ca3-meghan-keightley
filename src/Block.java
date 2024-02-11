public class Block {

   private int qty;
    private double price;

    public Block(int qty, double price){
        this.qty = qty;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


}
