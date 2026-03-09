package twodArrays;

import java.util.Scanner;

public class evenOddCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int evenCount = 0, oddCount = 0;
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
                if (matrix[i][j] % 2 == 0)
                    evenCount++;
                else
                    oddCount++;
            }
        }
        System.out.println("Even Numbers are: " + evenCount + "\nOdd Numbers are: " + oddCount);
    }
}
