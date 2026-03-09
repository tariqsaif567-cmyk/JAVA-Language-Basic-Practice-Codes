import java.util.*;
import java.io.*;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("attendance.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 1; i <= 10; i++) {
                System.out.printf("Enter Name of Student %d: ", i);
                String name = input.nextLine();
                System.out.print("Enter Attendance (P or p for present):");
                String attendance = input.nextLine();
                if (!attendance.equalsIgnoreCase("a"))
                    attendance = "P";
                else
                    attendance = "A";

                bw.write(name + " , " + attendance + "\n");
            }
            bw.close();
            System.out.println("\nNames and Attendences Added in File\n");

            Scanner input2 = new Scanner(file);
            File file2 = new File("attendance_summary.txt");
            PrintStream ps = new PrintStream(file2);

            int presentStudents = 0;
            int absentStudents = 0;
            while (input2.hasNextLine()) {
                String line = input2.nextLine();
                String attendance = line.substring(line.indexOf(",") + 1);
                attendance = attendance.trim();

                if (attendance.equalsIgnoreCase("P"))
                    presentStudents++;
                else
                    absentStudents++;
            }
            ps.println("Present Students: " + presentStudents);
            ps.println("Absent Students: " + absentStudents);

            ps.close();
            System.out.println("\nSummary Successfully Entered in New File");
            System.out.println("First Line has Present Students\nSecond Line has Absent Students");
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
