package Practices;

import java.util.Random;
import java.util.Scanner;

public class GridPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        char grid[][] = new char[5][5];

        int horizontal = 2, vertical = 2, foodCol = 4, foodRow = 4, score = 0;
        char choice = ' ';
        while (true) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    if (i == vertical && j == horizontal)
                        grid[i][j] = 'S';
                    else if (i == foodRow && j == foodCol)
                        grid[i][j] = 'F';
                    else
                        grid[i][j] = '_';

                    System.out.print(grid[i][j] + "");
                }
                System.out.println();
            }

            System.out.print("Enter your choice (W/S/A/D): ");
            choice = input.next().charAt(0);
            choice = Character.toUpperCase(choice);

            switch (choice) {
                case 'W':
                    vertical--;
                    break;
                case 'S':
                    vertical++;
                    break;
                case 'A':
                    horizontal--;
                    break;
                case 'D':
                    horizontal++;
                    break;
                case 'X':
                    System.out.println("Exited game.");
                    return;
                default:
                    System.out.println("Invalid key!");

            }

            if (choice == 'n')
                break;

            if (vertical == foodRow && horizontal == foodCol) {
                System.out.println("Yum! +1 point");
                score++;
                do {
                    foodRow = rand.nextInt(5);
                    foodCol = rand.nextInt(5);
                } while (foodRow == vertical && foodCol == horizontal);
            }

            if (vertical < 0 || vertical > 4 || horizontal < 0 || horizontal > 4) {
                System.out.println("Game Over! You hit the wall.");
                break;
            }
        }
        System.out.println("Score: " + score);

    }

}
