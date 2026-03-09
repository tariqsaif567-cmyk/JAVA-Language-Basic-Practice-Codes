import java.util.*;
import java.io.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("sample.txt");          
            PrintWriter pw = new PrintWriter(new FileWriter(file,true));
            while (true) {
                System.out.print("Enter String(null to break): ");
                String str = input.nextLine();
                if (str.isBlank())
                    break;
            pw.println(str);
            }
            System.out.println("\nStrings Successfully Added");
            pw.close();

            int words = 0;
            Scanner input2 = new Scanner(file);
            while (input2.hasNext()) {
                String str2 = input2.next();
                str2 = str2.toLowerCase();
                if (str2.charAt(0) >= 'a' && str2.charAt(0) <= 'z')
                    words++;
            }
            System.out.println("\nTotal Words in File are: " + words);
            input.close();
            input2.close();

        } catch (FileNotFoundException e1) {
            System.out.println("File not found! Recheck File Availibility or Path");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}