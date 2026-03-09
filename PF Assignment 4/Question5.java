import java.io.*;
import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        ArrayList<Integer> rollno = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> marksAll = new ArrayList<>();
        int maxMarks = Integer.MIN_VALUE;
        try {
            Scanner input = new Scanner(new File("students.txt"));
            while (input.hasNextLine()) {
                String str = input.nextLine();
                String[] line = str.split(",");
                int rollNo = Integer.parseInt(line[0]);
                String name = line[1];
                int marks = Integer.parseInt(line[2]);
                if (marks > maxMarks)
                    maxMarks = marks;

                rollno.add(rollNo);
                names.add(name);
                marksAll.add(marks);

            }
            input.close();

            System.out.print("Students with Maximum Marks are:| ");
            for (int i = 0; i < marksAll.size(); i++) {
                if (marksAll.get(i) == maxMarks)
                    System.out.print(names.get(i) + " | ");
            }

        } catch (FileNotFoundException e1) {
            System.out.println("File not Found");
        } catch (InputMismatchException e3) {
            System.out.println(e3.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
