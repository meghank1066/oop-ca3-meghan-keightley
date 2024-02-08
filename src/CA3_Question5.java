import java.util.*;


/**
 *  Name: Meghan Keightley
 *  Class Group: SD2A
 */

public class CA3_Question5 {

    public static void main(String[] args) {
        Queue<String> takeoff = new LinkedList<>();
        Queue<String> landing = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        boolean runsim = true;

        while (runsim) {

            System.out.println("Enter command (takeoff,land,next or quit)");
            String input = sc.nextLine();
            String[] numandinput = input.split(" ");
            //splits into array of strings :) e.g numandinput[0] = takeoff, numandinput[1] = the number of the flight

            //checking if its greater than or equal to 1
            if (numandinput.length >= 1) {
                String newinput = numandinput[0];

                switch (newinput) {

                    case "takeoff":
                        if (numandinput.length >= 2) {
                            String flightSymbol = numandinput[1];
                            if (!takeoff.contains(flightSymbol) && !landing.contains(flightSymbol)) {
                                takeoff.add(flightSymbol);
                                System.out.println("Takeoff queue: " + takeoff);
                                System.out.println("Land queue: " + landing);
                                System.out.println("takeoff " + flightSymbol + " is now in the queue");
                            } else {
                                System.out.println("Flight " + flightSymbol + " is already in the queue");
                                System.out.println("Takeoff queue: " + takeoff);
                                System.out.println("Land queue: " + landing);
                            }
                        } else {
                            System.out.println("enter a flight number for takeoff");
                        }
                        break;
                    case "land":
                        if (numandinput.length >= 2) {
                            String flightSymbol = numandinput[1];
                            if (!landing.contains(flightSymbol) && !takeoff.contains(flightSymbol)) {
                                landing.add(flightSymbol);
                                System.out.println("Takeoff queue: " + takeoff);
                                System.out.println("Land queue: " + landing);
                                System.out.println("land " + flightSymbol + " is now in the queue");
                            } else {
                                System.out.println("Flight " + flightSymbol + " is already in the queue");
                                System.out.println("Takeoff queue: " + takeoff);
                                System.out.println("Land queue: " + landing);
                            }
                        } else {
                            System.out.println("Please enter a flight number for landing");
                        }
                        break;
                    case "next":
                        if (!landing.isEmpty()) {
                            String flight = landing.poll();
                            System.out.println(flight + " has landed");
                        } else if (!takeoff.isEmpty()) {
                            String flight = takeoff.poll();
                            System.out.println(flight + " has taken off");
                        } else {
                            System.out.println("Both queues are empty");
                            break;
                        }
                        System.out.println("Takeoff queue: " + takeoff);
                        System.out.println("Land queue: " + landing);
                        break;
                    case "quit":
                        System.out.println("Simulation ends");
                        runsim = false;
                        break;
                        }
                }

            }


        }
    }


