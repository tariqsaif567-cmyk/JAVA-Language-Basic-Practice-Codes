package Chapter6;

import java.util.Scanner;

public class Q6point16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Base: ");
        double base = input.nextDouble();
        System.out.print("Enter Perpendicular: ");
        double perpendicular = input.nextDouble();
        System.out.println("The hypotenuse of given sides is : " + Hypotenuse(perpendicular, base));

    }

    public static double Hypotenuse(double a, double b) {
        double hyp = Math.sqrt((Math.pow(a, 2) + (Math.pow(b, 2))));
        return hyp;
    }

}
