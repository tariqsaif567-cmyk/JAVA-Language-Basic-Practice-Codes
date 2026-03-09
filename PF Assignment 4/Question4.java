import java.util.*;
import java.io.*;

public class Question4 {
    public static void main(String[] args) {
        ArrayList<Integer> rollno = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> marksAll = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("students.txt"));
            while (input.hasNext()) {
                String str = input.nextLine();
                String[] line = str.split(",");
                int rollNo = Integer.parseInt(line[0]);
                String name = line[1];
                int marks = Integer.parseInt(line[2]);
                if (marks < 50)
                    continue;

                rollno.add(rollNo);
                names.add(name);
                marksAll.add(marks);

            }
            input.close();
            PrintWriter pw = new PrintWriter(new FileWriter("students.txt"));
            for (int i = 0; i < rollno.size(); i++) {
                pw.printf("%d,%s,%d%n", rollno.get(i), names.get(i), marksAll.get(i));
            }
            pw.close();
            System.out.println("Files Updated Successfully.");

        } catch (FileNotFoundException e1) {
            System.out.println("File not Found");
        } catch (IOException e2) {
            System.out.println(e2.toString());
        } catch (InputMismatchException e3) {
            System.out.println(e3.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}