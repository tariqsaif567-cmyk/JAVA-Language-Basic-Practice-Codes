package Arrays;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many terms are there? ");
        int terms = input.nextInt();
        int arr[] = new int[terms];
        arr[0] = input.nextInt();
        int max = arr[0];
        for (int i = 1; i < terms; i++) {
            arr[i] = input.nextInt();
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("Biggest value in array is: " + max);
    }

}
