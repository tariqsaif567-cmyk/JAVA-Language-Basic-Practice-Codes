import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Values for Matrix ");
        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int columns = input.nextInt();
        System.out.println("Input values row by row ");
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();

            }
        }

        System.out.print("\nEnter the column index you want the sum of : ");
        int index = input.nextInt();

        while (true) {
            if (index >= 0 && index < columns) {
                System.out.println("The sum of Column Values is: " + sumColumn(matrix, index));
                break;
            } else {
                System.out.println("Column does not exist, enter again: ");
                index = input.nextInt();
            }

        }
    }

    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++)
            sum += m[i][columnIndex];

        return sum;
    }
}
