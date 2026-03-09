//package Lab13;

import java.util.*;
import java.io.*;

public class Activity4 {

    public static void main(String[] args) {
        try {
            File file = new File("MyData.txt");
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
        } catch (FileNotFoundException e1) {
            System.out.println("File not Found Check Again");
        } catch (InputMismatchException e2) {
            System.out.println("Incorrect Value for File! Check Code");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
