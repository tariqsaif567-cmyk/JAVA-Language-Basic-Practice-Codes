import java.util.Scanner;

public class Question6 {
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

        if (columns1 == rows2) {
            int[][] result = new int[rows1][columns2];
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns2; j++) {
                    for (int k = 0; k < columns1; k++)
                        result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }

            System.out.println("\nMatrix A is: ");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    System.out.print(matrixA[i][j] + "\t");

                }
                System.out.println();
            }

            System.out.println("Matrix B is: ");
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < columns2; j++) {
                    System.out.print(matrixB[i][j] + "\t");

                }
                System.out.println();
            }

            System.out.println("Product of A and B is: ");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns2; j++) {
                    System.out.print(result[i][j] + "\t");

                }
                System.out.println();
            }

        } else
            System.out.println("Incompatible sizes of Matrices for Multiplication");

    }
}
