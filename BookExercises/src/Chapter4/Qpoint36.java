package Chapter4;

import java.util.Scanner;

public class Qpoint36 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first value: ");
        int one = input.nextInt();
        System.out.print("Enter second value: ");
        int two = input.nextInt();
        System.out.print("Enter third value: ");
        int three = input.nextInt();

        if ((one * one) == (two * two) + (three * three)) {
            System.out.println("Values are from a right angled triangle.");
        } else if ((three * three) == (one * one) + (two * two)) {
            System.out.println("Values are from a right angled triangle.");
        } else if ((two * two) == (one * one) + (three * three)) {
            System.out.println("Values are from a right angled triangle.");
        } else {
            System.out.println("Values are not from a right angled triangle.");
        }

    }
}
