package Chapter4;

import java.util.Scanner;

public class Qpoint24 {

    public static void main(String[] args) {
        int pass = 0, fail = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter your value " + i + ": ");
            int value = input.nextInt();
            while (value != 1 && value != 2) {
                System.out.print("Enter your value " + i + " again: ");
                value = input.nextInt();
            }
            if (value == 1) {
                pass++;
            } else {
                fail++;
            }

        }
        System.out.printf("Passed: %d%nFailed: %d%n", pass, fail);

    }

}
