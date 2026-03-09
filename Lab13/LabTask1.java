//package Lab13;

import java.util.*;
import java.io.*;

public class LabTask1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("10Integers.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (int i = 0; i < 10; i++) {
                System.out.printf("Enter Integer %d: ", (i + 1));
                int number = input.nextInt();
                pw.println(number);
            }
            pw.close();
            input.close();
            System.out.println("\nData Successfully Entered");

        } catch (IOException e1) {
            System.out.println(e1.toString());
        } catch (InputMismatchException e2) {
            System.out.println(e2.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
