package Chapter4;

import java.util.Scanner;

public class Qpoint21 {

    public static void main(String[] args) {
        System.out.print("Enter sales of sales Person 1: ");
        Scanner input = new Scanner(System.in);

        int largest = input.nextInt();

        for (int counter = 2; counter <= 10; counter++) {
            System.out.print("Enter sales of sales Person " + counter + ": ");
            int number = input.nextInt();
            if (largest < number) {
                largest = number;
            }
        }
        System.out.println("The largest number is :" + largest);
        input.close();
    }
}
