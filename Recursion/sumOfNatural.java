package Recursion;

import java.util.Scanner;

public class sumOfNatural {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int num = input.nextInt();
        if (num > 0)
            System.out.println("The sum of natural numbers upto " + num + " is: " + Sum(num));
        else
            System.out.println("Incorrect value entered.");
    }

    public static int Sum(int n) {
        int sum = 0;
        if (n == 0)
            return 0;
        else
            sum = n + Sum(n - 1);

        return sum;
    }
}
