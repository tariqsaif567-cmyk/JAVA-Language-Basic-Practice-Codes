package Recursion;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        if (num > 0)
            System.out.println("The sum of digits of number is: " + SumOfDig(num));

    }

    public static int SumOfDig(int n) {
        int sum = 0, lastdig;
        if (n == 0)
            return 0;
        else
            lastdig = n % 10;
        n /= 10;

        sum = lastdig + SumOfDig(n);

        return sum;
    }

}
