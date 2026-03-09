package FileHandling;

import java.io.*;
import java.util.Scanner;

public class Write {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("File Menu\n1) Write to File\n2) Read from File");
        System.out.print("Enter your choice:");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                WriteProducts();
                break;
            case 2:
                GetInfo();
                break;
        }

    }

    public static void WriteProducts() {

        try {
            PrintStream ps = new PrintStream("Hello.txt");

            while (true) {
                System.out.print("Enter product ID: ");
                int id = input.nextInt();
                input.nextLine();

                if (id == 0)
                    break;
                System.out.print("Enter product name: ");
                String product = input.nextLine();

                System.out.print("Enter product quantity: ");
                int quantity = input.nextInt();
                System.out.print("Enter product price: ");
                int price = input.nextInt();
                ps.println(id + "," + product + "," + quantity + "," + price);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void GetInfo() {
        File file = new File("Hello.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                
                int id = Integer.parseInt(parts[0]);
                String product = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                
                System.out.println("Product id: " + id);
                System.out.println("Product name: " + product);
                System.out.println("Product quantity: " + quantity);
                System.out.println("Product price: " + price);
                System.out.println("----------------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
