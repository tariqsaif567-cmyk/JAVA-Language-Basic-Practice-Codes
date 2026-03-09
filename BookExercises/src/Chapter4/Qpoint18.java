package Chapter4;

import java.util.Scanner;

public class Qpoint18 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your account Number(0 to quit): ");
        int account = input.nextInt();

        while (account != 0) {

            System.out.printf("Enter your balance at the beginning of the month: ");
            int beginningBalance = input.nextInt();
            System.out.printf("Enter your total of all items charged this month: ");
            int totalCharge = input.nextInt();
            System.out.printf("Enter the total of all credits applied to your account this month: ");
            int totalCredits = input.nextInt();
            System.out.printf("Enter allowed credit limit: ");
            int creditLimit = input.nextInt();

            int newBalance = beginningBalance + totalCharge - totalCredits;
            if (creditLimit < newBalance) {
                System.out.print("The account number is: " + account);
                System.out.println("Credit limit exceeded");
            } else {
                System.out.printf("The account number is: " + account);
                System.out.printf("%nThe new balance is: " + newBalance);
            }
            System.out.printf("%nEnter your account Number(0 to quit): ");
            account = input.nextInt();
        }
        System.out.println("The process is finished and program is terminating.");

    }
}
