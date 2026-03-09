package Practices;

public class Primes {
    public static void main(String[] args) {
        System.out.println(2);
        for (int i = 3; i < 10000; i += 2) {
            if (Prime(i))
                System.out.println(i);
        }

    }

    public static boolean Prime(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }

        }

        return isPrime;
    }

}
