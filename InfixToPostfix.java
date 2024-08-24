/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project4;
import java.util.Scanner;

/*Design and implement two classes called InfixToPostfix and PostFixCalculator. The InfixToPostfix class converts an infix expression to a postfix expression. 
The PostFixCalculator class evaluates a postfix expression. This means that the expressions will have already been converted into the correct postfix form.
Write a main method that prompts the user to enter an expression in the infix form, converts it into a postfix, and displays the postfix expression as well as its evaluation. 
For simplicity, use only these operators, +, - , *, /, and %. Use the ArrayStack for this exercise.*/

/**
 *
 * @author heathermaclean
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter an infix expression:");
        String input = scan.nextLine();
        System.out.println(infixToPostFix(input));
        System.out.println(PostFixCalculator.postFixCalculator(infixToPostFix(input)));
    }
    public static String infixToPostFix(String infix){
        ArrayStack a = new ArrayStack(infix.length());
        String postfix = "";        
        
        for (int i = 0; i < infix.length(); i++){
            if (infix.charAt(i) > 47 && infix.charAt(i) < 58) // if number just add to postfix
                postfix = postfix + infix.charAt(i);
            else if (infix.charAt(i) == '(') {
                a.push(infix.charAt(i));
            } 
            else if (infix.charAt(i) == ')') { // if in parentheses ignore p
                while (!a.isEmpty() && a.peek() != '(') {
                    postfix = postfix + a.pop();
                }
                a.pop(); // Discard '('
            } 
            else{                
                while (!a.isEmpty() && precedence(infix.charAt(i)) <= precedence(a.peek())) 
                    postfix = postfix + a.pop(); // pop all operators with higher precedence than current infix op and add to postfix
                a.push(infix.charAt(i)); // push all operators onto stack
            }        
        }
        while (!a.isEmpty())
            postfix = postfix + a.pop(); // add remaining operators from stack to postfix expression

        return postfix;
    }
    static private int precedence(char operator){
       if (operator == '%' || operator == '*' || operator == '/' )
           return 1;
       else if (operator == '+' || operator == '-')
           return 2;
       else
            return -1;
    }
}
class PostFixCalculator{
    public static int postFixCalculator(String postfix){
        IntArrayStack a = new IntArrayStack(postfix.length());
        for(int i = 0; i < postfix.length(); i++){
            int temp = postfix.charAt(i);
            if (temp > 47 && temp < 58){
                temp-= 48;
                a.push(temp);
            }
            else {
                int x = a.pop();
                int y = a.pop();
                if(temp == '*')
                    a.push(x*y);
                else if(temp == '%')
                    a.push(y%x);
                else if(temp == '/')
                    a.push(y/x);
                else if(temp == '+')
                    a.push(y+x);
                else if(temp == '-')
                    a.push(y-x);
                else
                    return -1;
        }
    }
        return a.pop();
}
}
