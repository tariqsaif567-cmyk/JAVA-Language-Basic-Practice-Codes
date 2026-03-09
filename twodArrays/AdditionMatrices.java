package twodArrays;

import java.util.Scanner;

public class AdditionMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nFor First Matrix\nEnter rows: ");
        int rows1 = input.nextInt();
        System.out.print("Enter columns: ");
        int columns1 = input.nextInt();

        int[][] matrixA = new int[rows1][columns1];
        System.out.println();
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                System.out.print("Enter[" + i + "][" + j + "]:");
                matrixA[i][j] = input.nextInt();

            }
        }

        System.out.print("\nFor Second Matrix\nEnter rows: ");
        int rows2 = input.nextInt();
        System.out.print("Enter columns: ");
        int columns2 = input.nextInt();

        int[][] matrixB = new int[rows2][columns2];
        System.out.println();
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                System.out.print("Enter[" + i + "][" + j + "]:");
                matrixB[i][j] = input.nextInt();

            }
        }

        if (rows1 == rows2 && columns1 == columns2) {
            int[][] sum = new int[rows1][columns1];
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    sum[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            System.out.println("\nMatrix A is: ");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    System.out.print(matrixA[i][j] + "\t");

                }
                System.out.println("\n");
            }

            System.out.println("Matrix B is: ");
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < columns2; j++) {
                    System.out.print(matrixB[i][j] + "\t");

                }
                System.out.println("\n");
            }

            System.out.println("Sum of both Matrices is: ");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    System.out.print(sum[i][j] + "\t");

                }
                System.out.println("\n");
            }

        } else
            System.out.println("Incompatible sizes of Matrices for Addition");

    }
}
