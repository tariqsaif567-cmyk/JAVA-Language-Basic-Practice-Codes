//package Lab13;

import java.util.*;
import java.io.*;

public class Activity1 {

    public static void main(String[] args) {

        char[] ch = { 'a', 'b', 'v', 'd', 'e', 'g', 'h' };
        try {
            File file = new File("Characters.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (int i = 0; i < ch.length; i++) {
                pw.println(ch[i]);
            }
            pw.close();
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                char alphaNumeric = input.next().charAt(0);
                System.out.println(alphaNumeric);
            }
            input.close();

        } catch (FileNotFoundException e1) {
            System.out.println(e1.toString());
        } catch (IOException e2) {
            System.out.println(e2.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
