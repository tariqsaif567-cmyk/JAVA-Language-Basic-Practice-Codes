package twodArrays;

import java.util.Scanner;

public class Symmetric {
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

            System.out.println("\nTranspose of Matrix is: ");
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(transpose[i][j] + "\t");

                }
                System.out.println();
            }

            boolean symmetric = true;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] != transpose[i][j]) {
                        symmetric = false;
                        break;
                    }

                }
                if (!symmetric)
                    break;
            }

            if(symmetric)
            System.out.println("\nThe matrix is symmetric");
            else
            System.out.println("\nThe matrix is not symmetric");

        }
    }
}
