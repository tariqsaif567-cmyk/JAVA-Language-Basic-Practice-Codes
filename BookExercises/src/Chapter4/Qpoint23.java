package Chapter4;

import java.util.Scanner;

public class Qpoint23 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int largest, secondlargest;

        System.out.print("Enter sales of sales Person 1: ");
        int first = input.nextInt();
        System.out.print("Enter sales of sales Person 2: ");
        int second = input.nextInt();
        if (first > second) {
            largest = first;
            secondlargest = second;
        } else {
            largest = second;
            secondlargest = first;
        }

        for (int counter = 3; counter <= 10; counter++) {
            System.out.print("Enter sales of sales Person " + counter + ": ");
            int number = input.nextInt();

            if (largest <= number) {
                secondlargest = largest;
                largest = number;

            } else if (number > secondlargest) {
                secondlargest = number;

            }
        }
        System.out.println("The largest number is :" + largest);
        System.out.println("The second largest number is :" + secondlargest);

        input.close();
    }
}
