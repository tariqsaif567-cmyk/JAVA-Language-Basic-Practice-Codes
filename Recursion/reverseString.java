package Recursion;

import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your String: ");
        String str = input.nextLine();
        System.out.println("The reversed String is: " + Reverse(str));
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
