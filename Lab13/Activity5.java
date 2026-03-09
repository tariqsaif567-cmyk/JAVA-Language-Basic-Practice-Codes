//package Lab13;

import java.util.*;
import java.io.*;

public class Activity5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("students.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            while (true) {
                System.out.print("Enter Roll no: ");
                int rollno = input.nextInt();
                if (rollno == 0)
                    break;
                input.nextLine();
                System.out.print("Enter Name: ");
                String name = input.nextLine();
                System.out.print("Enter Marks (out of 100): ");
                int marks = input.nextInt();
                pw.println(rollno);
                pw.println(name);
                pw.println(marks);
            }
            pw.close();
            input.close();
            System.out.println("Data Added Successfully");

        } catch (IOException e1) {
            System.out.println(e1.toString());
        } catch (InputMismatchException e2) {
            System.out.println(e2.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
