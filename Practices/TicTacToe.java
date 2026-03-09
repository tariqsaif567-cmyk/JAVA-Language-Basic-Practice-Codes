package Practices;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char choice, playeroption = 'X';
        boolean cnd1 = false, cnd2 = false, cnd3 = false, cnd4 = false, cnd5 = false, cnd6 = false;
        int row, column, player = 1;
        char game[][] = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game[i][j] = '_';
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }

        while (true) {
            if (player > 2) {
                player = 1;
            }
            if (player == 1) {
                playeroption = 'X';
            } else {
                playeroption = 'O';
            }
            System.out.println("Enter " + playeroption + " for player " + player);
            System.out.print("Enter the row(0,1,2): ");
            row = input.nextInt();
            System.out.print("Enter the column(0,1,2): ");
            column = input.nextInt();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == row && j == column) {
                        if (player == 1)
                            game[i][j] = 'X';
                        else
                            game[i][j] = 'O';

                        System.out.print(game[i][j] + " ");
                    } else
                        System.out.print(game[i][j] + " ");
                }
                System.out.println();
            }

            if (game[0][0] != '_') {
                cnd1 = game[0][0] == game[1][1] && game[1][1] == game[2][2];
                cnd3 = game[0][0] == game[1][0] && game[1][0] == game[2][0];
                cnd4 = game[0][0] == game[0][1] && game[0][1] == game[0][2];
            }
            if (game[0][2] != '_') {
                cnd5 = game[0][2] == game[1][2] && game[1][2] == game[2][2];
                cnd2 = game[0][2] == game[1][1] && game[1][1] == game[2][0];
            }
            if (game[2][0] != '_') {
                cnd6 = game[2][0] == game[2][1] && game[2][1] == game[2][2];
            }

            if (cnd1 || cnd2 || cnd3 || cnd4 || cnd5 || cnd6) {
                if (game[0][0] == 'X' || game[0][2] == 'X' || game[2][0] == 'X') {
                    System.out.println("Player 1 wins. Game end.");
                    break;
                } else {
                    System.out.println("Player 2 wins. Game end.");
                    break;
                }
            }

            player++;
        }

    }

}
