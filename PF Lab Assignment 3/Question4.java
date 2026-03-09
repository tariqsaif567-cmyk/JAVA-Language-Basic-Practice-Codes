import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] rainFall = new int[5][12];
        int[] sumRainfall = new int[rainFall.length];
        int largest = Integer.MIN_VALUE;
        int largestIndex = 0;

        for (int i = 0; i < rainFall.length; i++) {
            System.out.println("Input Rainfall information for City " + (i + 1));
            for (int j = 0; j < rainFall[i].length; j++) {
                System.out.print("Enter the RainFall condition for Month " + (j + 1) + " in mm :");
                rainFall[i][j] = input.nextInt();
                sumRainfall[i] += rainFall[i][j];
            }

            System.out.println();
        }
        for (int i = 0; i < sumRainfall.length; i++) {
            System.out.println("Total rainfall in city " + (i + 1) + " (in mm) is: " + sumRainfall[i]);
            if (largest < sumRainfall[i]) {
                largest = sumRainfall[i];
                largestIndex = i;
            }
        }

        System.out.println("The city with the greatest amount of rain is city " + (largestIndex + 1) + " with "
                + largest + " in mm");
        
    }

}
