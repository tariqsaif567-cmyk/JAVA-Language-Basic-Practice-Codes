import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] studentMarks = new int[3][4];
        for (int i = 0; i < studentMarks.length; i++) {
            System.out.println("Input Marks for Student " + (i + 1));
            for (int j = 0; j < studentMarks[i].length; j++) {
                System.out.print("Enter Marks(Out of 100) of Subject " + (j + 1) + " : ");
                studentMarks[i][j] = input.nextInt();

            }
            System.out.println();
        }

        double sum;
        double average;
        for (int i = 0; i < studentMarks.length; i++) {
            sum = 0;
            for (int j = 0; j < studentMarks[i].length; j++) {
                sum += studentMarks[i][j];
            }
            average = sum / studentMarks[i].length;
            System.out.println("The Average Marks of Student " + (i + 1) + " are: " + average);
        }

        System.out.println();
        int largest;
        for (int i = 0; i < studentMarks[0].length; i++) {
            largest = Integer.MIN_VALUE;
            for (int j = 0; j < studentMarks.length; j++) {
                if (studentMarks[j][i] > largest)
                    largest = studentMarks[j][i];

            }
            System.out.println("The highest marks in Subject " + (i + 1) + " are : " + largest);
        }

        

    }
}
