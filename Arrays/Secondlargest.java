package Arrays;

import java.util.Scanner;

public class Secondlargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many elements in Array? ");
        int size = input.nextInt();
        int max = Integer.MIN_VALUE;
        int second = 0;
        int arr[] = new int[size];
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                arr[i] = input.nextInt();
                if (arr[i] > max) {
                    second = max;
                    max = arr[i];
                } else if (arr[i] > second) {
                    second = arr[i];
                }
            }
            System.out.println("The second largest number in the array is: " + second);
        }

    }

}
