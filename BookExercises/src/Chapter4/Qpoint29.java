package Chapter4;

import java.util.Scanner;

public class Qpoint29 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of side of a square: ");
        int size = input.nextInt();
        for (int row = 1; row <= size; row++) {
            for (int column = 1; column <= size; column++) {
                if (row == 1 || row == size || column == 1 || column == size) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }
}

