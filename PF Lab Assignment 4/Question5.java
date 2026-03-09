import java.util.*;
import java.io.*;

public class Question5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("enrollment.txt");
            PrintStream ps = new PrintStream(file);

            System.out.println("Enter data of each Student with spaces as (StudentID Name Course Status)");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("Enter Data of Student %d: ", i);
                String id = input.next();               
                String name = input.next();                
                String course = input.next();              
                String status = input.next();
                ps.printf("%-20s%-20s%-20s%-20s%n", id, name, course, status);
            }
            ps.close();

            int enrolled = 0;
            int dropped = 0;

            Scanner input2 = new Scanner(file);
            System.out.println("\nStudents enrolled in The Programming Course\n");
            while (input2.hasNextLine()) {
                String line = input2.nextLine();
                String courseStatus = line.substring(60);
                courseStatus = courseStatus.trim();

                if (courseStatus.equalsIgnoreCase("Enrolled"))
                    enrolled++;
                else if (courseStatus.equalsIgnoreCase("Dropped"))
                    dropped++;

                String course = line.substring(40, 60);
                course = course.trim();

                if (!course.equalsIgnoreCase("Programming"))
                    continue;

                System.out.println(line);

            }

            System.out.println("\nEnrolled Students : " + enrolled);
            System.out.println("Dropped Students : " + dropped);
            input.close();
            input2.close();

        } catch (FileNotFoundException e1) {
            System.out.println("File not Found! Check Path Again");
        } catch (IOException e2) {
            System.out.println(e2.toString());
        } catch (Exception e3) {
            System.out.println(e3.toString());
        }
    }
}
