package Chapter4;

import java.util.Scanner;

public class Qpoint20 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("For Employee no " + i);
            System.out.print("Enter the number of hours worked: ");
            int hoursWorked = input.nextInt();
            System.out.print("Enter the hourly pay rate: ");
            double hourlyPay = input.nextDouble();
            int normalHours;
            int overtimeHours;
            if (hoursWorked > 40) {
                overtimeHours = (hoursWorked - 40);
                normalHours = hoursWorked - overtimeHours;
            } else {
                overtimeHours = 0;
                normalHours = hoursWorked;
            }
            double grossPay = (normalHours * hourlyPay) + (overtimeHours * hourlyPay * 1.5);
            System.out.printf("Gross pay of employee %d is: %.2f%n%n", i, grossPay);

        }
        input.close();

    }
}
