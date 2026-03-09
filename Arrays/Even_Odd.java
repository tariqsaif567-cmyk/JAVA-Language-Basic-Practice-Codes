package Arrays;

import java.util.Scanner;

public class Even_Odd {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many terms are there? ");
        int terms = input.nextInt();
        int arr[] = new int[terms];
        int even = 0, odd = 0;
        for (int i = 0; i < terms; i++) {
            arr[i] = input.nextInt();
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even numbers in Array: " + even + "\nOdd numbers in Array: " + odd);
    }

}
