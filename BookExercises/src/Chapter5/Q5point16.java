package Chapter5;

import java.util.Scanner;

public class Q5point16 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer between 1 and 30: ");
        int num1 = input.nextInt();
        System.out.print("Enter an integer between 1 and 30: ");
        int num2 = input.nextInt();
        System.out.print("Enter an integer between 1 and 30: ");
        int num3 = input.nextInt();
        System.out.print("Enter an integer between 1 and 30: ");
        int num4 = input.nextInt();
        System.out.print("Enter an integer between 1 and 30: ");
        int num5 = input.nextInt();

        if ((num1 >= 1 && num1 <= 30) && (num2 >= 1 && num2 <= 30) && (num3 >= 1 && num3 <= 30) && (num4 >= 1 && num4 <= 30) && (num5 >= 1 && num5 <= 30)) {
            System.out.println();
            for (int i = 1; i <= num1; i++) {
                System.out.print("*");
            }
            System.out.println();

            for (int i = 1; i <= num2; i++) {
                System.out.print("*");
            }
            System.out.println();

            for (int i = 1; i <= num3; i++) {
                System.out.print("*");
            }
            System.out.println();

            for (int i = 1; i <= num4; i++) {
                System.out.print("*");
            }
            System.out.println();

            for (int i = 1; i <= num5; i++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}
