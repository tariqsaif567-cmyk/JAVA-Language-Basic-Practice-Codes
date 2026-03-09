package Recursion;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String str = input.nextLine();
        if (Palindrome(str))
            System.out.println("The string is a palindrome");
        else
            System.out.println("The string is not a palindrome");
    }

    public static boolean Palindrome(String str) {
        if (str.equalsIgnoreCase(Reverse(str)))
            return true;
        else
            return false;
    }

    public static String Reverse(String str) {
        String reverse = "";
        int length = str.length() - 1;
        if (length == 0)
            return str.charAt(0) + "";
        else
            reverse = str.charAt(length) + Reverse(str.substring(0, length));
        return reverse;
    }

}
