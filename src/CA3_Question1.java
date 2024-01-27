
import java.util.Scanner;
import java.util.*;

/**
 *  Name: Meghan Keightley
 *  Class Group: SD2A
 */
public class CA3_Question1 {

    public static void runSimulation() {

        Deque<Integer> driveway = new ArrayDeque<>();
        Deque<Integer> street = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);

        int input;

        System.out.println("Enter a number to add a car to the driveway, " +
                "or a negative number to remove a car from the driveway. Enter 0 to stop the simulation.");
        while (true) {
            input = sc.nextInt();
            if (input > 0) {
                driveway.push(input);
            } else if (input < 0) {
                int getCar = Math.abs(input);
                //math.abs returns the positive value of a number, so if we type -4 from the driveway we get 4


                //push driveway cars to the street until our car is found
                while(!driveway.isEmpty() && driveway.peek() != getCar){
                    int moveCar = driveway.pop();
                    System.out.println(moveCar + " is being moved to the street ");
                    street.push(moveCar);
                    System.out.println("Driveway: " + driveway);
                    System.out.println("Street: " + street);
                }

                //when the car is found pop it from the driveway
                if(!driveway.isEmpty() && driveway.peek() == getCar) {
                    int removedCar = driveway.pop();
                    System.out.println("Car found: " + getCar);
                    System.out.println("Removing car " + removedCar + " from the driveway");
                } else {
                    System.out.println("Car not found: " + getCar );
                }

            } else if (input == 0) {
                 break;
             }

            System.out.println("Driveway: " + driveway);
            System.out.println("Street: " + street);
        }

    }

    public static void main(String[] args) {
        runSimulation();
    }

}