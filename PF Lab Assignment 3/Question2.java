import java.util.Random;

public class Question2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] seats = new int[5][10];
        int totalEmptySeats = 0;
        int emptyRowSeats[] = new int[seats.length];

        System.out.println("\nThe seating Arrangement display\n");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = random.nextInt(2);
                if (seats[i][j] == 0) {
                    totalEmptySeats++;
                    emptyRowSeats[i]++;
                }
                System.out.print(seats[i][j] + "\t");

            }
            System.out.println();

        }

        for (int i = 0; i < seats.length; i++)
            System.out.print("\nThe number of empty seats per row in row " + (i + 1) + " is: " + emptyRowSeats[i]);

        System.out.println("\n\nThe number of empty seats in the theater is: " + totalEmptySeats);
    }
}