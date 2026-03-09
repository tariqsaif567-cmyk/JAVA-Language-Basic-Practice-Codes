package Arrays;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many values are there: ");
        int terms = input.nextInt();
        int nums[] = new int[terms];
        int sum = 0;
        if (terms >= 1) {
            for (int i = 0; i < terms; i++) {
                nums[i] = input.nextInt();
                sum += nums[i];
            }
            System.out.println(sum);
        }

    }

}
