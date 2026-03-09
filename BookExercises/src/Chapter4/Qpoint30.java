package Chapter4;

import java.util.Scanner;

public class Qpoint30 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a five digit integer: ");
        int number = input.nextInt();
        if (number >= 10000 && number <= 99999) {
            int num1 = number / 10000;

            int num2 = (number / 1000) % 10;

            int num4 = (number / 10) % 10;
            int num5 = number % 10;
            if (num1 == num5 && num2 == num4) {
                System.out.println("The number is a palindrome.");
            } else {
                System.out.println("The number is not a palindrome.");

            }

        } else {
            System.out.println("Incorrect value.");
        }
    }
}
