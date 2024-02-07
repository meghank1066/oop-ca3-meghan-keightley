import java.util.*;


/**
 *  Name: Meghan Keightley
 *  Class Group: SD2A
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {
        Queue<String> takeoff = new LinkedList<>();
        Queue<String> landing = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        boolean runsim = true;

        while(runsim) {

            System.out.println("Enter command (takeoff,land,next or quit)");
            String input = sc.next();
            String flightsymbol;

            switch(input) {
                case "takeoff":
                    System.out.println("enter flight number");
                    flightsymbol = sc.next();
                    //if takeoffqueue doesnt already have that flight number &
                    if(!takeoff.contains(flightsymbol) && !landing.contains(flightsymbol))
                        takeoff.add(flightsymbol);
                    System.out.println("takeoff " + flightsymbol + " is now in the queue");
                    System.out.println("Takeoff queue: " + takeoff);
                    System.out.println("Land queue: " + landing);
                    break;
                case "land":
                    System.out.println("enter flight number");
                    flightsymbol = sc.next();
                    if (!landing.contains(flightsymbol) && !takeoff.contains(flightsymbol)) {
                        landing.add(flightsymbol);
                        System.out.println("land " + flightsymbol + " is now in the queue");

                    } else {
                        System.out.println("land " + flightsymbol + " is already in the queue");
                    }
                    System.out.println("Takeoff queue: " + takeoff);
                    System.out.println("Land queue: " + landing);
                    break;
                case "next":
                    if(!landing.isEmpty()) {
                        String flight = landing.poll();
                        System.out.println( flight + " has landed");
                        System.out.println("Takeoff queue: " + takeoff);
                        System.out.println("Land queue: " + landing);
                    } else if(!takeoff.isEmpty()){
                        String flight = takeoff.poll();
                        System.out.println(flight + " has taken off");
                        System.out.println("Takeoff queue: " + takeoff);
                        System.out.println("Land queue: " + landing);

                    } else {
                        System.out.println("queue is empty");
                        System.out.println("Takeoff queue: " + takeoff);
                        System.out.println("Land queue: " + landing);
                    }
                    break;
                case "quit":
                    System.out.println("Simulation ends");
                    runsim = false;
                    break;
            }

            
        }

    }
}
