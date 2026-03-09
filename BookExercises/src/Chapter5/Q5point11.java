package Chapter5;

import java.util.Scanner;

public class Q5point11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of integers required: ");
        int numbers = input.nextInt();

        if (numbers >= 1) {

            System.out.print(1 + ") Enter your number:");
            int smaller = input.nextInt();

            for (int i = 2; i <= numbers; i++) {
                System.out.print(i + ") Enter your number:");
                int larger = input.nextInt();

                if (smaller > larger) {
                    smaller = larger;
                }
            }
            System.out.println("The smallest integer is: " + smaller);

        }
    }
}
