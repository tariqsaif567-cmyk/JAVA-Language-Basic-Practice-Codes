//package Lab13;

import java.util.*;
import java.io.*;

public class Activity2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ch;
        boolean isQ = false;
        try {

            File file = new File("Characters.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            System.out.print("Enter Characters Seperated by Spaces(q to break): ");
            while (true) {
                String str = input.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    ch = str.charAt(i);
                    if (ch == 'q') {
                        isQ = true;
                        break;
                    }
                    pw.print(ch);
                }
                if (isQ)
                    break;

            }
            pw.close();
            input.close();

            System.out.println("\nCharacters Successfully Written.\n");
            Scanner input2 = new Scanner(file);
            System.out.print("The characters are: ");
            while (input2.hasNextLine()) {
                String line = input2.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char alphaNumeric = line.charAt(i);
                    System.out.print(alphaNumeric);
                }
            }
            input2.close();

        } catch (FileNotFoundException e1) {
            System.out.println(e1.toString());
        } catch (IOException e2) {
            System.out.println(e2.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
