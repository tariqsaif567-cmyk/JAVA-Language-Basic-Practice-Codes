package Arrays;

import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many terms are there? ");
        int size = input.nextInt();
        int arr[] = new int[size];
        double sum = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        System.out.printf("Average of values in array is: %.2f%n", (sum / size));
    }

}
