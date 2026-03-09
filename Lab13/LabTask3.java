import java.util.*;
import java.io.*;

public class LabTask3 {
    public static void main(String[] args) {

        try {
            File file = new File("10Integers.txt");

            Scanner input = new Scanner(file);
            ArrayList<Integer> numbers = new ArrayList<>();

            while (input.hasNextInt()) {
                int value = input.nextInt();
                if (!isPrime(value)) {
                    numbers.add(value);
                }
            }
            input.close();

            PrintWriter pw = new PrintWriter(new FileWriter(file));

            for (int n : numbers) {
                pw.println(n);
            }

            pw.close();

            System.out.println("Prime numbers removed successfully!");

        } catch (IOException e1) {
            System.out.println(e1.toString());
        } catch (InputMismatchException e2) {
            System.out.println(e2.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
