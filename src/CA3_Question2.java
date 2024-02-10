import java.util.Scanner;
import java.util.Stack;


/**
 *  Name: Meghan Keightley
 *  Class Group: SD2A
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> fillup = new Stack<>();
        int fillNumber = 1;

        fillup.push(new Pair(r, c));

        while (!fillup.isEmpty()) {
            Pair block = fillup.pop();

            if (arr[block.getRow()][block.getCol()] == 0) {
                arr[block.getRow()][block.getCol()] = fillNumber++;
                //north east south west
               int[][]compass = {{-1,0},{0,1},{1,0},{0,-1}};

               //check in each direction & calculate next coordinates for eahc row and column
                for(int[]direction : compass){
                    int addRow = block.getRow() + direction[0];
                    int addCol = block.getCol() + direction[1];

                    //checking if valid & for not off the grid
                    if (addRow >= 0 && addRow < arr.length && addCol >= 0 && addCol < arr[0].length && arr[addRow][addCol] == 0) {
                        fillup.push(new Pair(addRow, addCol));
                    }

            }
        }
    }



    }

    public static void start()
    {
        int[][] arr = floodFillStart();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the starting row");
        int userRow = scanner.nextInt();

        System.out.println("Enter the starting col");
        int userCol = scanner.nextInt();

        fill(userRow,userCol, arr);
        display(arr);

    }
    public static void main(String[] args) {
        start();
    }

}
