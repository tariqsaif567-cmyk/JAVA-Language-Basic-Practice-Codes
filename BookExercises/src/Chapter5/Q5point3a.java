package Chapter5;

public class Q5point3a {

    public static void main(String[] args) {
        int sum = 0;
        for (int count = 1; count <= 99; count += 2) {
            sum += count;
        }
        System.out.println("The sum is: " + sum);
    }
}
