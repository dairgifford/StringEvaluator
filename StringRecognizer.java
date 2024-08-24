/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project4;

import java.util.Scanner;


public class StringRecognizer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Enter a string: ");
        String teststring = input.nextLine();

        if (inLang(teststring)) 
            System.out.println("The string is in the language");
        else 
            System.out.println("The string is not in the language");
        
    }

    // Checks if the input string is in the language L
    public static boolean inLang(String teststring) {
        int dollarIndex = teststring.indexOf('$');
        if (dollarIndex < 0) {
            return false; // string doesn't contain '$'
        }
        
        String w = teststring.substring(0, dollarIndex);
        String w2 = teststring.substring(dollarIndex + 1);
        LinkedStack l = new LinkedStack();
        
        if (w.length() != w2.length())
            return false;
        
        for(int i = 0; i < w2.length(); i++)
            l.push(w2.charAt(i));

        for(int i = 0; i < w.length(); i++){
            if (w.charAt(i) != l.pop())
                return false; // if any chars don't match it means w' is not the reverse of w and thus not in language
        }

        return true; // if $ is in string, lengths match, and chars of w' reversed match w string is in the language
    }
}