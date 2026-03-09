package Chapter4;

import java.util.Scanner;

public class Qpoint38bMyLogic {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the encrypted four-digit integer: ");
        int value = input.nextInt();

        while (true) {

            if (value >= 1000 && value <= 9999) {

                int num1 = value / 1000;
                int num2 = (value / 100) % 10;
                int num3 = (value / 10) % 10;
                int num4 = value % 10;

                num1 = (num1 - 7 + 10) % 10;
                num2 = (num2 - 7 + 10) % 10;
                num3 = (num3 - 7 + 10) % 10;
                num4 = (num4 - 7 + 10) % 10;

                int temp1 = num1;
                num1 = num3;
                num3 = temp1;

                int temp2 = num2;
                num2 = num4;
                num4 = temp2;

                System.out.println("Your decrypted value is: " + num1 + "" + num2 + "" + num3 + "" + num4);

                break;

            } else {
                System.out.print("Incorrect value!Input a four digit number: ");
                value = input.nextInt();

            }

        }
    }
}
