package twodArrays;

import java.util.Scanner;

public class MaximumRowSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int columns = input.nextInt();
        int[] sum = new int[rows];

        int[][] matrix = new int[rows][columns];
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter[" + i + "][" + j + "]:");
                matrix[i][j] = input.nextInt();
                sum[i] += matrix[i][j];
            }
            System.out.println("The sum of Row " + i + " Values is: " + sum[i]);

        }

        int maxRowSum = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < rows; i++) {
            if (maxRowSum < sum[i]) {
                maxRowSum = sum[i];
                index = i;
            }
        }
        System.out.println("\nGreatest Row Sum is: " + maxRowSum + " of Row Index " + index);

    }
}
