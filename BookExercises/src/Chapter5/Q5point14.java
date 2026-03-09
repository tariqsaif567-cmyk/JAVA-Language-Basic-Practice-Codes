package Chapter5;

public class Q5point14 {

    public static void main(String[] args) {
        double amount;

        double principal = 1000.0;

        double rate = 0.05;

        System.out.printf("%s%29s%n", "Year", "Amount on deposit");

        for (rate = 0.05; rate <= 0.10; rate += 0.01) {
            System.out.printf("%nInterest Rate: %.0f%%%n", rate * 100);
            System.out.printf("%s%29s%n", "Year", "Amount on deposit");
            for (int year = 1; year <= 10; year++) {
                amount = principal * Math.pow(1.0 + rate, year);
                System.out.printf("%4d%,20.2f\n", year, amount);
            }
        }
    }

}
