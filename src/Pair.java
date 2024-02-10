public class Pair  {


private int row;
private int col;

//constructor
public Pair(int row, int col) {
 this.row = row;
 this.col = col;

}

//blank constructor
    public Pair() {
        this.row = 0;
        this.col = 0;

    }

    public int getRow() {
    return row;
    }

    public int getCol() {
        return col;
    }

}
