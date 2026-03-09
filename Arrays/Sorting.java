package Arrays;

import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] disorder = new int[10];
        int temp;
        System.out.println("Enter 10 int values");
        for (int i = 0; i < disorder.length; i++) {
            disorder[i] = input.nextInt();
        }

        for (int i = 0; i < disorder.length; i++) {
            for (int j = i + 1; j < disorder.length - 1; j++) {
                if (disorder[i] > disorder[j]) {
                    temp = disorder[j];
                    disorder[j] = disorder[i];
                    disorder[i] = temp;

                }
            }
        }
        for (int i = 0; i < disorder.length; i++) {
            System.out.print(disorder[i] + " ");
        }
    }
}
