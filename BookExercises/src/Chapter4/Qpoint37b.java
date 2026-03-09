package Chapter4;

import java.util.Scanner;

public class Qpoint37b {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount of terms: ");
        int count = input.nextInt();
        long factorial = 1;
        double e = 1;
        if (count > 0) {
            for (int i = 1; i <= count; i++) {
                factorial *= i;
                e += (1.0 / factorial);

            }
            System.out.println("Value of e upto " + count + " terms is: " + e);

        }

    }
}
