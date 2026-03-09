import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values you want to input: ");
        int length = input.nextInt();
        int[] arr = new int[length];

        System.out.println("\nEnter " + length + " values seperated by spaces");
        for (int i = 0; i < length; i++) {
            arr[i] = input.nextInt();
        }

        if (isConsecutiveFour(arr))
            System.out.println("The list has consecutive fours");
        else
            System.out.println("The list does not have consecutive fours");
    }

    public static boolean isConsecutiveFour(int[] values) {
        boolean isConsecutiveFour = false;
        int count = 1;

        for (int i = 0; i < values.length - 1; i++) {

            if (values[i] == values[i + 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count == 4) {
                isConsecutiveFour = true;
                break;
            }
        }

        return isConsecutiveFour;
    }
}