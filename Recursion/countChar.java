package Recursion;

import java.util.Scanner;

public class countChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your String: ");
        String str = input.nextLine();
        System.out.print("Enter your character: ");
        char ch = input.next().charAt(0);

        System.out.println("The number of times charcter occurs in String is: " + Counter(str, ch));
    }

    public static int Counter(String str, char ch) {
        int count;
        str = str.toLowerCase();
        ch = Character.toLowerCase(ch);
        int length = str.length();
        if (length == 0)
            return 0;
        else {
            if (str.charAt(0) == ch)
                count = 1 + Counter(str.substring(1, length), ch);
            else
                count = 0 + Counter(str.substring(1, length), ch);

            return count;
        }
    }

}
