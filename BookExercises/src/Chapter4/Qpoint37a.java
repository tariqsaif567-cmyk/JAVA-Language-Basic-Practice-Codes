package Chapter4;

import java.util.Scanner;

public class Qpoint37a {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative value: ");
        int value = input.nextInt();
        long factorial = 1;
        if (value >= 0) {
            for (int i = 1; i <= value; i++) {
                factorial *= i;

            }
            System.out.println("Factorial of " + value + " is: " + factorial);

        }

    }
}
