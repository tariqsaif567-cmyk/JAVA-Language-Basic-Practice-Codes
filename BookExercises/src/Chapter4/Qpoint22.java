package Chapter4;

public class Qpoint22 {

    public static void main(String[] args) {
        System.out.printf("%-6s%-7s%-8s%-9s%n", "N", "10*N", "100*N", "1000*N");
        for (int N = 1; N <= 5; N++) {
            System.out.printf("%-6d%-7d%-8d%-9d%n", N, 10*N, 100*N, 1000*N);

        }
    }
}
