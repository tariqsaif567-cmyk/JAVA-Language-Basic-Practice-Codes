package Arrays;

import java.util.Scanner;

public class copy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many terms in the array 1? ");
        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        System.out.print("How many elements more than Array1 in Array 2? ");
        int extraSize = input.nextInt();
        int copy[] = new int[size + extraSize];

        if (extraSize >= 0) {

            for (int j = 0; j < size; j++) {
                copy[j] = arr[j];
            }
            for (int k = size; k < size + extraSize; k++) {
                copy[k] = input.nextInt();
            }
            for (int i = 0; i < size + extraSize; i++) {
                System.out.print(copy[i] + " ");
            }
        }
    }

}
