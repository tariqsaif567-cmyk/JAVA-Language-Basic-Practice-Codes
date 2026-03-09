import java.util.*;
import java.io.*;

public class Question2 {
    public static void main(String[] args) {
        int above50 = 0;
        try {
            Scanner input = new Scanner(new File("students.txt"));
            while (input.hasNextLine()) {
                String str = input.nextLine();
                String[] line = str.split(",");
                int marks = Integer.parseInt(line[2]);
                if (marks > 50)
                    above50++;
            }
            System.out.println("The Number of students with Marks above 50 are: " + above50);
            input.close();
        } catch (IOException e1) {
            System.out.println("Error Reading File");
        } catch (InputMismatchException e2) {
            System.out.println(e2.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
