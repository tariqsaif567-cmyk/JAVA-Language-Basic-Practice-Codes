package SaraKaam;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What was the Star size(odd)?");
        int num = input.nextInt();
        if (num % 2 != 0) {
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    if (i == j || i + j == num + 1 || i == num / 2 + 1 || j == num / 2 + 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Odd Number required");
        }
    }

}
