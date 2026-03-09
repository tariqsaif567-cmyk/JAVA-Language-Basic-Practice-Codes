import java.util.*;
import java.io.*;

public class LabTask2 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        try {
            File file = new File("10Integers.txt");
            Scanner input = new Scanner(file);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = input.nextInt();
            }

            System.out.println("The Numbers in Sorted Order are: ");
            Arrays.sort(numbers);
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
            }
            input.close();

        } catch (IOException e1) {
            System.out.println(e1.toString());
        } catch (InputMismatchException e2) {
            System.out.println(e2.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
