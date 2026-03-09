package Recursion;

import java.util.Scanner;

public class exponent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("The the base number : ");
        int num = input.nextInt();
        System.out.print("The the exponent number : ");
        int exp = input.nextInt();

        if (num >= 1)
            System.out.println("The power of number " + num + " to base " + exp + " is: " + xPowerN(num, exp));
    }

    public static double xPowerN(int x, int n) {
        double result;
        if (n == 0)
            return 1;
        else
            result = x * xPowerN(x, n - 1);
        return result;
    }

}
