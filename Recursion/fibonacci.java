package Recursion;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number for fibonnacci sequence: ");
        int num = input.nextInt();
        System.out.println("The terms are as follows: ");
        for (int i = 1; i <= num; i++) {
            System.out.print(Fibonacci(i) + " ");
        }
    }

    public static int Fibonacci(int n) {
        int fibonacci = 0;
        if (n == 1)
            return 0;
        else if (n == 2 || n == 3)
            return 1;
        else
            fibonacci = Fibonacci(n - 1) + Fibonacci(n - 2);

        return fibonacci;
    }

}
