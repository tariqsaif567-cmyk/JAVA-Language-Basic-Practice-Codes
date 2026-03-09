import java.util.*;
import java.io.*;

public class Question2 {
    public static void main(String[] args) {
        int countJava = 0;
        try {
            File file = new File("book.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String str = input.next();
                str = str.toLowerCase();
                if (str.equals("java"))
                    countJava++;
            }
            System.out.println("The Number of times java occurs in file is: " + countJava);
            input.close();
        } catch (FileNotFoundException e1) {
            System.out.println("File not found! Recheck File Availibility or Path");
        } catch (Exception e2) {
            System.out.println(e2.toString());
        }
    }
}
