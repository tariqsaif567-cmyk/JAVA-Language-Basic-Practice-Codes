package Chapter4;

import java.util.Scanner;

public class Qpoint17 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the miles driven: ");
        int miles = input.nextInt();
        double sum = 0;
        double average = 0;

        int rounds = 0;
        while (miles != 0) {
            System.out.print("Input the gallons of petrol: ");
            int gallons = input.nextInt();
            double milesPerGallon = (double) miles / gallons;
            System.out.printf("The miles per gallon are :%.2f%n%n", milesPerGallon);
            sum += milesPerGallon;
            ++rounds;
            average = sum / rounds;

            System.out.print("Input the miles driven: ");
            miles = input.nextInt();

        }
        if(rounds>0)
        System.out.printf("%nThe total miles per gallon are :%.2f%n", average);
        else
            System.out.println("No distance travelled.");
    }
}
