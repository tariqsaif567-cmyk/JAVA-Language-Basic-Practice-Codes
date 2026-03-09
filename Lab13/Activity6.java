//package Lab13;

import java.util.*;
import java.io.*;

public class Activity6 {

    public static void main(String[] args) {
        try {
            File file = new File("students.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int rollno = input.nextInt();
                System.out.println("Roll no : " + rollno);
                input.nextLine();
                String name = input.nextLine();
                System.out.println("Name : " + name);
                int marks = input.nextInt();
                System.out.println("Marks : " + marks);
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
