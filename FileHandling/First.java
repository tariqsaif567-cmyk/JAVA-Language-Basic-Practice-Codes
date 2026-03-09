package FileHandling;

import java.io.*;

public class First {
    public static void main(String[] args) {

        try {
            File basic = new File("Hello.txt");

            if (basic.createNewFile())
                System.out.println("Succesfully created");
            else
                System.out.println("File already exists.");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
