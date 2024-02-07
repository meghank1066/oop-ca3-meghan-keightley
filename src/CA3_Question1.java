
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

        int number;

        System.out.println("Enter a number to add a car to the driveway, " +
                "or a negative number to remove a car from the driveway. Enter 0 to stop the simulation.");

        //TO START PROGRAM:
        while (true) {

            //checking if integer
            while(!sc.hasNextInt() && sc.hasNext()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }


            number = sc.nextInt();
            if (number > 0) {

                //we need to check if the car isnt already there to avoid duplicate numbers
                if(driveway.contains(number)) {
                    System.out.println("Car already in driveway");
                } else {
                    driveway.push(number);
                }

            } else if (number < 0) {
                int getCar = Math.abs(number);
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

                //once the car is found, pop the cars in the street that aren't the wanted car back to the driveway
                while (!street.isEmpty()) {
                    int returnedCar = street.pop();
                    driveway.push(returnedCar);
                    System.out.println("Returning car " + returnedCar + " to the driveway");
                    System.out.println("Driveway: " + driveway);
                    System.out.println("Street: " + street);
                }

            } else if (number == 0) {

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