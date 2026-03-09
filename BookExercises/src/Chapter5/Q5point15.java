package Chapter5;

public class Q5point15 {

    public static void main(String[] args) {
        System.out.println("Pattern A\n");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Pattern B\n");

        for (int k = 10; k >= 1; k--) {
            for (int l = 1; l <= k; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Pattern C\n");

        for (int k = 10; k >= 1; k--) {
            int o = 1;
            for (int i = 0; i < o; i++) {
                System.out.print(" ");
            }
            for (int l = 1; l <= k; l++) {
                System.out.print("*");
                o++;
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Pattern D\n");
        for (int i = 1; i <= 10; i++) {
            for (int l = 10; l > i; l--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

    }

}
