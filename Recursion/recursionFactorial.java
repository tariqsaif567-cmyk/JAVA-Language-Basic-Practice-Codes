package Recursion;
import java.util.Scanner;

public class recursionFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for factorial: ");
        System.out.println("The factorial of number is: " + Factorial(input.nextInt()));
    }

    public static int Factorial(int n) {
        int factorial = 0;
        if (n == 0 || n == 1)
            return 1;
        else
            factorial = n * Factorial(n - 1);

        return factorial;
    }
}
