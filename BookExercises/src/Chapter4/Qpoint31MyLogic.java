package Chapter4;

import java.util.Scanner;

public class Qpoint31MyLogic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary digit: ");
        String binary = input.next();
        int digits = binary.length();
        int index;
        int decimal = 0;
        int sum = 0;
        int number = digits - 1;

        for (index = 0; index <= digits - 1; index++) {
            decimal = (int) ((binary.charAt(index) - '0') * (Math.pow(2, number)));
            sum += decimal;
            number--;
        }
        System.out.println("The decimal sum of value is: " + sum);

    }
}
