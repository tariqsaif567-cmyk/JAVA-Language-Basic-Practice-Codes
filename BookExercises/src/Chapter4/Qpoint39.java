package Chapter4;

import java.util.Scanner;

public class Qpoint39 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        System.out.print("Enter the world population (in billion): ");
        double population = input.nextDouble();
        System.out.print("Enter the world population growth rate(1 for 1 percent): ");
        double growthRate = input.nextDouble() / 100;
        double increase = 0;
        double updated = 0;
        double compare = population;

        System.out.printf("%-10s%-10s%-10s%-10s%n", "Year", "Present", "Updated", "Increase");

        for (int i = 1; i <= 75; i++) {
            System.out.printf("%-10s%-10.2f", year, population);
            updated = population + (population * growthRate);
            System.out.printf("%-10.2f", updated);

            increase = updated - population;
            population += (population * growthRate);
            System.out.printf("%-10.2f%n", increase);
            year++;
        }
        if (population >= 2 * compare) {
            System.out.println("\nPopulation has doubled in the last 75 years.");
        } else {
            System.out.println("\nPopulation has not doubled in the last 75 years.");
        }
        int doubleYear = year;
        while (population < 2 * compare) {
            population += (population * growthRate);
            doubleYear++;
        }
        System.out.println("Population will double around the year " + doubleYear + ".");

    }
}
