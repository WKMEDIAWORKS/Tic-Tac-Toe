import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        playGame(board);
    }

    static void playGame(char[][] board) {
        Scanner input = new Scanner(System.in);
        boolean isPlayer1Turn = true;
        int turns = 0;

        while (true) {
            displayTheBoard(board);
            if (isPlayer1Turn) {
                System.out.println("Player 1 (X), it's your turn.");
                if (!makeMove(board, 'X', input)) continue;
            } else {
                System.out.println("Player 2 (O), it's your turn.");
                if (!makeMove(board, 'O', input)) continue;
            }

            if (result(board)) {
                displayTheBoard(board);
                break;
            }

            turns++;
            if (turns == 9) {
                System.out.println("It's a draw!");
                break;
            }

            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    static boolean makeMove(char[][] board, char symbol, Scanner input) {
        int row, col;
        while (true) {
            System.out.println("Enter row (0, 1, 2): ");
            row = input.nextInt();
            System.out.println("Enter column (0, 1, 2): ");
            col = input.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position. Please enter row and column between 0 and 2.");
            } else if (board[row][col] != ' ') {
                System.out.println("The position is already taken. Please choose another.");
            } else {
                board[row][col] = symbol;
                return true;
            }
        }
    }

    static void displayTheBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < board[i].length - 1) System.out.print("|");
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("---|---|---");
            }
        }
    }

    static boolean result(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                System.out.println("Player " + (board[i][0] == 'X' ? "1" : "2") + " wins!");
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                System.out.println("Player " + (board[0][i] == 'X' ? "1" : "2") + " wins!");
                return true;
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            System.out.println("Player " + (board[0][0] == 'X' ? "1" : "2") + " wins!");
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            System.out.println("Player " + (board[0][2] == 'X' ? "1" : "2") + " wins!");
            return true;
        }

        return false;
    }
}
