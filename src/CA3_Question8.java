import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CA3_Question8 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {


        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("enter equation");
        equation = in.nextLine().trim();
        //.trim to remove whitespace

        Deque<Double> numberstack = new ArrayDeque<>();
        //keep track of numbers in expression
        Deque<Character> operatorstack = new ArrayDeque<>();
        //to keep track of symbols: /()*+ etc

        String operators = "+-*/";

        //loop to go through each character on the string
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);


            if (Character.isDigit(c)) {
                //if digit found, convert to double and push onto number deque
                double num = Character.getNumericValue(c);
                numberstack.push(num);
            } else if (operators.contains(String.valueOf(c))) {
                //if an operator push into op deque
                operatorstack.push(c);
            } else if (c == ')') {
                //if closing, processing operator till open one is found
                while (!operatorstack.isEmpty() && operatorstack.peek() != '(') {
                    findoperator(numberstack, operatorstack);
                }
                // popping our opening parenthesis from the operator stack
                operatorstack.pop();
            } else if (c == '(') {
                //if opening tag, push onto deque
                operatorstack.push(c);
            }
        }

        //eliminate other operators on deques
        while (!operatorstack.isEmpty()) {
            findoperator(numberstack, operatorstack);
        }

        //we make it so that our result is the only element left on deque
        double result = numberstack.pop();
        System.out.println("our result: " + result);
    }
    private static void findoperator(Deque<Double> numberstack, Deque<Character> operatorstack) {
        char operator = operatorstack.pop();
        double operator2 = numberstack.pop();
        double operator1 = numberstack.pop();

        if (operator == '+') {
            numberstack.push(operator1 + operator2);
        } else if (operator == '-') {
            numberstack.push(operator1 - operator2);
        } else if (operator == '*') {
            numberstack.push(operator1 * operator2);
        } else if (operator == '/') {
            numberstack.push(operator1 / operator2);
        }
    
    }
}