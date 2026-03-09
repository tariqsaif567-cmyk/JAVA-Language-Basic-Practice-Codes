package twodArrays;

import java.util.Scanner;

public class SumInColumns {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print("Enter[" + j + "][" + i + "]:");
                matrix[j][i] = input.nextInt();
                sum += matrix[j][i];
            }
            System.out.println("The sum of Columns " + (i + 1) + " Values is: " + sum);
            sum = 0;
        }

    }
}
