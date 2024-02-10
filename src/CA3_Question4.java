import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Meghan Keightley
 *  Class Group: SD2A
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        try {
            File tagfile = new File(filename);
            Scanner scanner = new Scanner(tagfile);

            Deque<String> findtags = new ArrayDeque<>();


            while(scanner.hasNext()){
                String tag = scanner.next();

                //checking if its closing
                if (tag.startsWith("</")) {
                    String closedtag = tag.substring(2, tag.length() - 1);
                    //-1 gets index of the last tag, find the letter
                    //assiging the letter to help us find the opening tag

                    if (findtags.isEmpty() || !findtags.removeLast().equals(closedtag)) {
                        return false;
                    }

                } else if (tag.startsWith("<")) {
                    // checking for an opening tag
                   String opentag = tag.substring(1, tag.length() - 1);
                    findtags.addLast(opentag);
                    // adding to the tag list to identify if nested
                }

            }
            //we have it so it returns empty if nested properly
            return findtags.isEmpty();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e); //returns if file not found
        }
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
