package twodArrays;

import java.util.Scanner;

public class Identitycheck {
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

        if (rows != columns) {
            System.out.println("Not an identity matrix - must be square!");
            return;
        }

        boolean identity = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    if (matrix[i][j] != 1) {
                        identity = false;
                        break;
                    }
                } else if (matrix[i][j] != 0) {
                    identity = false;
                    break;
                }
            }
        }
        if (identity)
            System.out.println("\nIt is an Identity Matrix");
        else
            System.out.println("Not an identity Matrix");
    }
}
