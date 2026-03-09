package SaraKaam;

public class battery {
    public static void main(String[] args) throws InterruptedException {

        int health = 100;

        while (health >= 0) {
            int filled = health / 10;
            int empty = 10 - filled;

            System.out.print("\rLoading health... ");
            Thread.sleep(500);

            System.out.print("\rRemaining health: [");
            for (int i = 0; i < filled; i++)
                System.out.print("█");
            for (int i = 0; i < empty; i++)
                System.out.print("░");
            System.out.print("] " + health + "%   ");

            if (health <= 20 && health > 0) {
                System.out.print("  Health Critical!!! ");
            }
            if (health == 0) {
                System.out.println("\nYou have died.");
                break;
            }

            Thread.sleep(600);
            health -= 10;
        }
    }
}
