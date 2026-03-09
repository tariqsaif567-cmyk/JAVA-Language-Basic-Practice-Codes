//package Lab13;

import java.io.*;

public class Activity3 {

    public static void main(String[] args) {
        int rollno = 105;
        String name = "SAIF TARIQ";
        int marks = 99;
        try {
            File file = new File("MyData.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.println(rollno);
            pw.println(name);
            pw.println(marks);
            pw.close();
            System.out.println("Data Successfully Inputted.");
        } catch (IOException e1) {
            System.out.println(e1.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
