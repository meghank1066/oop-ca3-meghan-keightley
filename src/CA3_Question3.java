import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CA3_Question3 {
    public static void readFile(String fileName) throws FileNotFoundException {
        // Map to store identifiers, corresponding line numbers, and occurrence count
        Map<String, StringBuilder> identifiermap = new HashMap<>();
        Map<String, Integer> counter = new HashMap<>();

        try (Scanner in = new Scanner(new File(fileName))) {
            // set
            in.useDelimiter("[^A-Za-z0-9_]+");

            // Variable to keep track of the current line number
            int linenum = 0;

            // going through the file line by line
            while (in.hasNextLine()) {
                linenum++;

                // reading each variable/identifier in the line
                while (in.hasNext()) {
                    String identifier = in.next();
                    System.out.println("found identifier: " + identifier + " line: " + linenum);


                    // updating the map with linenum & increments the counter
                    if (!identifiermap.containsKey(identifier)) {
                        //if key is found,
                        identifiermap.put(identifier, new StringBuilder());
                        counter.put(identifier, 1);
                    } else {
                        counter.put(identifier, counter.get(identifier) + 1);
                    }

                    //
                    identifiermap.get(identifier).append("Line ").append(linenum).append("\n");
                }
            }

            // Print the result
            for (Map.Entry<String, StringBuilder> entry : identifiermap.entrySet()) {
                System.out.println("Identifier: " + entry.getKey());
                System.out.println(entry.getValue().toString());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
