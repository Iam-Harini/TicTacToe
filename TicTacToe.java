package com.myGames;
import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            char[][] board = initializeBoard();
            char currentPlayer = 'X';
            boolean gameWon = false;
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("============================= Game Begins! ============================");

            while (!gameWon) {
                printBoard(board);
                System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                System.out.println();

                if (isValidMove(board, row, col)) {
                    board[row][col] = currentPlayer;
                    gameWon = checkWin(board, currentPlayer);

                    if (!gameWon && isBoardFull(board)) {
                        System.out.println("Game Draw!");
                        break;
                    }

                    if (gameWon) {
                        System.out.println("Player " + currentPlayer + " has won!");
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again!");
                }
            }

            printBoard(board);
            System.out.println("Do you want to play again? Press 1 for yes, 0 for no: ");
            
            int choice = scanner.nextInt();
            playAgain = (choice == 1);
        }

        System.out.println("====================== Thanks for Playing! ======================");
    }

    public static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        return board;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == ' ');
    }

    public static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
