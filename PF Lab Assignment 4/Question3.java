import java.util.*;
import java.io.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("number.txt");
            PrintWriter pw = new PrintWriter(file);
            while (true) {
                System.out.print("Enter a Number(Null to break): ");
                String numberStr = input.nextLine();
                if (numberStr.isBlank())
                    break;
                pw.println(numberStr);
            }
            pw.close();
            System.out.println("\nNumbers Successfully Added to File\n");

            System.out.print("Enter a Number you want to Search: ");
            int num = input.nextInt();
            boolean exists = false;

            Scanner input2 = new Scanner(file);
            while (input2.hasNextInt()) {
                int number = input2.nextInt();
                if (num == number) {
                    exists = true;
                    break;
                }
            }
            input.close();
            input2.close();

            if (exists)
                System.out.println("The Number " + num + " exists in the File");
            else
                System.out.println("The Number " + num + " does not exist in the File");

        } catch (FileNotFoundException e1) {
            System.out.println("File not found! Recheck File Availibility or Path");
        } catch (InputMismatchException e2) {
            System.out.println(e2.toString());
        } catch (Exception e3) {
            System.out.println(e3.toString());
        }
    }
}
