package twodArrays;

import java.util.Scanner;

public class ClockWise90 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nFor Matrix Input\nEnter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter[" + i + "][" + j + "]:");
                matrix[i][j] = input.nextInt();

            }
        }

        System.out.println("\nMatrix is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");

            }
            System.out.println();
        }

        if (rows == columns) {

            int[][] transpose = new int[columns][rows];

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    transpose[i][j] = matrix[j][i];

                }
                System.out.println();
            }

            System.out.println("The Clockwise 90 Degree Turned Matrix is:");
            for (int i = 0; i < columns; i++) {
                for (int j = rows - 1; j >= 0; j--) {
                    System.out.print(transpose[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("Square Matrix Required");
        }
    }
}