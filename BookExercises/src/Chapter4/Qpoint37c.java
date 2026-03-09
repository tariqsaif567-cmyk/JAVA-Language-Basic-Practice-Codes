package Chapter4;

import java.util.Scanner;

public class Qpoint37c {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of x: ");
        double value = input.nextDouble();
        System.out.print("Enter the amount of terms: ");
        int count = input.nextInt();

        long factorial = 1;
        double ePowerx = 1;
        if (count > 0) {
            for (int i = 1; i <= count; i++) {
                factorial *= i;
                ePowerx += (Math.pow(value,i) / factorial);

            }
            System.out.println("Value of e^x upto " + count + " terms is: " + ePowerx);

        }

    }
}
