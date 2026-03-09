import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int columns = input.nextInt();
        int rowIndex = 0;
        int columnIndex = 0;
        int rowLargest = Integer.MIN_VALUE;
        int columnLargest = Integer.MIN_VALUE;
        int sum;

        int[][] matrix = new int[rows][columns];
        System.out.println("\nEnter values row by row");
        for (int i = 0; i < rows; i++) {
            sum = 0;
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.nextInt();
                sum += matrix[i][j];
            }
            if (rowLargest < sum) {
                rowLargest = sum;
                rowIndex = i;
            }

        }

        for (int i = 0; i < columns; i++) {
            sum = 0;
            for (int j = 0; j < rows; j++) {
                sum += matrix[j][i];
            }
            if (columnLargest < sum) {
                columnLargest = sum;
                columnIndex = i;
            }

        }

        System.out.println("\nGreatest Row Sum is: " + rowLargest + " of Row Index " + rowIndex);
        System.out.println("\nGreatest Column Sum is: " + columnLargest + " of Column Index " + columnIndex);

    }
}
