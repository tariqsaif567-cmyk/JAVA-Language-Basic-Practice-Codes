package Chapter5;

public class Q5point3d {

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%4d", i);
            if (i % 5 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }

        }
    }

}
