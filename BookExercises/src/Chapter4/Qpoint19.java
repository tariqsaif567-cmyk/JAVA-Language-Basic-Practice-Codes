package Chapter4;

import java.util.Scanner;

public class Qpoint19 {

    public static void main(String[] args) {
        double item1 = 239.99;
        double item2 = 129.75;
        double item3 = 99.95;
        double item4 = 350.89;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter sales of item 1: ");
        int sale1 = input.nextInt();
        System.out.print("Enter sales of item 2: ");
        int sale2 = input.nextInt();
        System.out.print("Enter sales of item 3: ");
        int sale3 = input.nextInt();
        System.out.print("Enter sales of item 4: ");
        int sale4 = input.nextInt();

        double totalSales = (item1 * sale1) + (item2 * sale2) + (item3 * sale3) + (item4 * sale4);
        double Salary = 200 + (totalSales*0.09);

        System.out.printf("The total earnings of salesperson are : %.2f%n", Salary);
    }
}
