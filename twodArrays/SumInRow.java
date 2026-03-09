package twodArrays;

import java.util.Scanner;

public class SumInRow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter[" + i + "][" + j + "]:");
                matrix[i][j] = input.nextInt();
                sum += matrix[i][j];
            }
            System.out.println("The sum of Row " + (i + 1) + " Values is: " + sum);
            sum = 0;
        }

    }
}
