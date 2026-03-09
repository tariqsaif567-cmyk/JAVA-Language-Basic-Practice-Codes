import java.util.Random;

public class Question8 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] matrix = new int[4][4];
        int[] rowOnes = new int[matrix.length];
        int[] columnOnes = new int[matrix[0].length];
        int rowIndex = 0;
        int columnIndex = 0;

        System.out.println("The Matrix is Displayed");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(2);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    rowOnes[i]++;
            }

        for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1)
                    columnOnes[i]++;
            }

        for (int i = 0; i < matrix.length; i++) {
            if (rowOnes[i] > rowOnes[rowIndex]) {
                rowIndex = i;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (columnOnes[i] > columnOnes[columnIndex]) {
                columnIndex = i;
            }
        }

        System.out.println("\nThe largest Row index is: " + rowIndex);
        System.out.println("The largest Column index is: " + columnIndex);
    }
}
