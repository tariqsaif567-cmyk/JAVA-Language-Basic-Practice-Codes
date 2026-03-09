package BS;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int q = input.nextInt();

        if (q >= 0 && q <= 500) {
            for (int j = 1; j <= q; j++) {
                int a = input.nextInt();
                int b = input.nextInt();
                int n = input.nextInt();
                int result = a;
                if (a >= 0 && b <= 50 && n >= 1 && n <= 15) {
                    for (int i = 0; i < n; i++) {
                        result += b * Math.pow(2, i);
                        System.out.print(result + " ");
                    }
                    System.out.println();
                } else {
                    break;
                }
            }
        }

    }
}