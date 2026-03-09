package Arrays;

import java.util.Scanner;

public class Search {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many terms are there? ");
        int terms = input.nextInt();
        int arr[] = new int[terms];
        int num = 6;
        int position = 1;
        boolean found = false;
        for (int i = 0; i < terms; i++) {
            arr[i] = input.nextInt();
            if (arr[i] == num) {
                found = true;
                break;
            }
            position++;

        }
        if (found)
            System.out.println("The number is within the array in Position " + position);
        else
            System.out.println("Number not in array");
    }
}
