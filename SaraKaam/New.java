package SaraKaam;
import java.util.Scanner;

public class New {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number here: ");
        int num = input.nextInt();
        for (int j = 1; j <= num; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print("*");
            }System.out.println();
        }
    }
}