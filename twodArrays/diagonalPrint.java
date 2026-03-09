package twodArrays;

import java.util.Scanner;

public class diagonalPrint {
    public static void main(String[] args) {

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nFor Array Values\nEnter rows: ");
            int rows = input.nextInt();
            System.out.print("Enter columns: ");
            int columns = input.nextInt();

            if (rows == columns) {

                int[][] matrix = new int[rows][columns];
                System.out.println();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.print("Enter[" + i + "][" + j + "]:");
                        matrix[i][j] = input.nextInt();

                    }
                }

                System.out.println("\nThe Matrix Values are:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println("\nThe Main Diagonal Values are:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (i == j)
                            System.out.print(matrix[i][j] + " ");
                    }
                }

                System.out.println("\nThe Secondary Diagonal Values are:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (i + j == rows - 1)
                            System.out.print(matrix[i][j] + " ");
                    }
                }
                break;

            } else
                System.out.println("Square Matrix Required.");

        }
    }
}
