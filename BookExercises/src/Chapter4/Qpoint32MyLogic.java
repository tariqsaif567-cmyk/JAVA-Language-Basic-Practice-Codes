package Chapter4;

public class Qpoint32MyLogic {

    public static void main(String[] args) {
        for (int h = 1; h <= 4; h++) {
            for (int i = 1; i <= 8; i++) {
                System.out.print("* ");
                System.out.print(" ");
            }
            System.out.println();
            for (int j = 1; j <= 8; j++) {
                System.out.print(" ");
                System.out.print("* ");
            }
            System.out.println();

        }
    }
}
