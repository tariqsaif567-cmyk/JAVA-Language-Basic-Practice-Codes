package Chapter4;

import java.util.Scanner;

public class Qpoint31 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        int binary = input.nextInt(); // input as integer

        int decimal = 0;
        int base = 1; // positional value, starts at 2^0 = 1
        int temp = binary;

        while (temp > 0) {
            int lastDigit = temp % 10; // get the rightmost digit
            if (lastDigit != 0 && lastDigit != 1) {
                System.out.println("Error: Not a valid binary number.");
                return;
            }
            decimal += lastDigit * base; // add to decimal value
            base *= 2;                   // increase positional value
            temp /= 10;                   // remove the last digit
        }

        System.out.println("The decimal equivalent is: " + decimal);
    }
}
