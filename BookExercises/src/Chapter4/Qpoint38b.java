package Chapter4;

import java.util.Scanner;

public class Qpoint38b {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the encrypted four-digit integer: ");
        String value = input.next();

        while (true) {

            if (value.length() == 4 && value.matches("\\d{4}")) {

                int num1 = Character.getNumericValue(value.charAt(0));
                int num2 = Character.getNumericValue(value.charAt(1));
                int num3 = Character.getNumericValue(value.charAt(2));
                int num4 = Character.getNumericValue(value.charAt(3));

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
                value = input.next();

            }

        }
    }
}
