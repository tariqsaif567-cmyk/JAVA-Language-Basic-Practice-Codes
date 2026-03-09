package Recursion;

public class towerOfHanoi {
    public static void towerOfHanoi(int n, char from, char to, char helper) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }

        towerOfHanoi(n - 1, from, helper, to); // Move n-1 from A to B
        System.out.println("Move disk " + n + " from " + from + " to " + to); // Move nth to C
        towerOfHanoi(n - 1, helper, to, from); // Move n-1 from B to C
    }

    public static void main(String[] args) {
        int n = 3; // change this to test
        towerOfHanoi(n, 'A', 'C', 'B');
    }

}
