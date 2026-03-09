package BS;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n;
        int terms = input.nextInt();

        for (int i = 1; i <= terms; i++) {
            n = input.next();
            if (!isWithinLongRange(n)) {
                System.out.println(n + " can't be fitted anywhere.");
            } else if (Long.valueOf(n) < Math.pow(2, 8) && Long.valueOf(n) >= -Math.pow(2, 7)) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* byte\n* short\n* int\n* long");
            } else if (Long.valueOf(n) < Math.pow(2, 16) && Long.valueOf(n) >= -Math.pow(2, 15)) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* short\n* int\n* long");
            } else if (Long.valueOf(n) < Math.pow(2, 32) && Long.valueOf(n) >= -Math.pow(2, 31)) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* int\n* long");
            } else if (Long.valueOf(n) < Math.pow(2, 64) && Long.valueOf(n) >= -Math.pow(2, 63)) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* long");
            }

        }
    }

    public static boolean isWithinLongRange(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Remove negative sign for comparison
        String numberStr = str.startsWith("-") ? str.substring(1) : str;

        // Compare with Long.MAX_VALUE as string
        String longMaxStr = "9223372036854775807";

        // Quick check: if length is less, it's definitely within range
        if (numberStr.length() < longMaxStr.length()) {
            return true;
        }

        // If length is greater, it's definitely too large
        if (numberStr.length() > longMaxStr.length()) {
            return false;
        }

        // If same length, compare digit by digit
        return numberStr.compareTo(longMaxStr) <= 0;
    }

}
