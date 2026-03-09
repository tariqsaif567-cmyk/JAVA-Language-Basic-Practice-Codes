package Chapter4;

import java.util.Scanner;

public class Qpoint29myLogic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of side of square: ");
        int size = input.nextInt();
        for (int row = 1; row <= size; row++) {
            System.out.printf("%2s", "*");
        }
        System.out.println("");
        for (int column = 1; column <= (size - 2); column++) {
            System.out.printf("%2s%6s%n", "*", "*");
        }
        if (size > 1) {
            for (int row = 1; row <= size; row++) {
                System.out.printf("%2s", "*");
            }
            System.out.println("");
        }

    }

}
