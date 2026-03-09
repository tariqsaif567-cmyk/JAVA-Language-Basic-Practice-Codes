package Arrays;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many terms in the array? ");
        int size = input.nextInt();
        int arr[] = new int[size];
        int reverse[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        for (int j = 0; j < size; j++) {
            reverse[j] = arr[size - 1 - j];
            System.out.print(reverse[j] + " ");
        }
    }

}
