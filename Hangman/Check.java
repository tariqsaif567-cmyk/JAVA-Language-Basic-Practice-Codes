package Hangman;

import java.util.Scanner;
import java.util.Random;

public class Check {
    public static void main(String[] args) {
        Random value = new Random();
        Scanner input = new Scanner(System.in);
        int maxErrors = 6;
        char alphabet;
        String str;
        boolean same = false;
        boolean sameArray = true;
        System.out.print("Enter");
        int lenght = value.nextInt(7) + 4;
        char letter[] = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            letter[i] = (char) ((int) (Math.random() * 26) + 97);
        }
        char checker[] = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            checker[i] = '_';
        }
        while (maxErrors > 0) {
            same = false;
            sameArray = true;
            System.out.println(checker);
            System.out.print("Enter your alphabet: ");
            str = input.next();
            str = str.toLowerCase();
            alphabet = str.charAt(0);
            for (int i = 0; i < lenght; i++) {
                if (letter[i] == (alphabet)) {
                    checker[i] = alphabet;
                    same = true;
                }
            }
            if (!same)
                maxErrors--;
            for (int i = 0; i < lenght; i++) {
                if (letter[i] != checker[i]) {
                    sameArray = false;
                    break;
                }

            }
            if (sameArray) {
                break;
            }
        }
        if (sameArray) {
            System.out.println("\nCongratulations you have correctly guessed the random word");
            System.out.println(new String(letter));
        } else {
            System.out.print("\nYou were unable to guess correctly hence you lose.The correct word was: ");
            System.out.println(new String(letter));
        }
        input.close();
    }
}
