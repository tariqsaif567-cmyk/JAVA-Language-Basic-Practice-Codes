package twodArrays;

import java.util.Scanner;

public class search {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("\nFor Array Values\nEnter rows: ");
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

        System.out.print("Enter Number to search: ");
        int searchKey = input.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (searchKey == matrix[i][j]) {
                    System.out.println("\nNumber found at index " + i + " of row and " + j + " of Column");
                    return;
                }

            }
        }
        System.out.println("Number not found");
    }
}
