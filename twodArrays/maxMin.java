package twodArrays;

import java.util.Scanner;

public class maxMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
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
                if (largest < matrix[i][j])
                    largest = matrix[i][j];
                if (smallest > matrix[i][j])
                    smallest = matrix[i][j];
            }
        }
        System.out.println("The smallest Value in Array is: " + smallest);
        System.out.println("The largest Value in Array is: " + largest);
    }
}
