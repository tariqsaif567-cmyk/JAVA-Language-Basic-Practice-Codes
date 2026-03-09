package Chapter4;

import java.util.Scanner;

public class Qpoint35 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first value: ");
        double one = input.nextDouble();
        System.out.print("Enter second value: ");
        double two = input.nextDouble();
        System.out.print("Enter third value: ");
        double three = input.nextDouble();

        if ((one + two > three) && (one + three > two) && (two + three > one)) {
            System.out.println("Values are from a triangle.");
        } else {
            System.out.println("Values are not from a triangle.");
        }

    }
}
