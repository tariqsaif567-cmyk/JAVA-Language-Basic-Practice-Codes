package Recursion;

import java.util.Scanner;

public class GreatestCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.println("The Greatest Common Factor between numbers is: " + GCD(num1, num2));
    }

    public static int GCD(int a, int b) {
        int gcd, temp;
        if (b > a) {
            temp = a;
            a = b;
            b = temp;
        }
        if (b == 0)
            return a;
        else
            temp = b;
        b = a % b;
        a = temp;

        gcd = GCD(a, b);
        return gcd;
    }
}
