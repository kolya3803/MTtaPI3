import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);
        TicTacToeBoard board = new TicTacToeBoard();

        System.out.print("Player 1 name is ");
        Player player1 = new Player(stringScanner.next(), 'X');
        System.out.print("Player 2 name is ");
        Player player2 = new Player(stringScanner.next(), 'O');

        boolean isPlayer1Turn = true;
        boolean gameEnded = false;

        while (!gameEnded) {
            board.printBoard();
            Player currentPlayer = isPlayer1Turn ? player1 : player2;
            System.out.println(currentPlayer.getName() + " turn (" + currentPlayer.getSymbol() + "):");

            int row, col;
            do {
                row = currentPlayer.makeMove("Enter row (1-3): ");
                col = currentPlayer.makeMove("Enter column (1-3): ");
            } while (!board.isMoveValid(row, col));

            board.updateBoard(row, col, currentPlayer.getSymbol());

            if (board.checkForWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                isPlayer1Turn = !isPlayer1Turn;
            }
        }
    }
}

