package Chapter6;

public class Qpoint17 {
    public static void main(String[] args) {
        System.out.println(isMultiple(3, 9));
        System.out.println(isMultiple(4, 5));
        System.out.println(isMultiple(3, 18));
        System.out.println(isMultiple(2, 12));

    }

    public static boolean isMultiple(int a, int b) {
        return b % a == 0;
    }
}
