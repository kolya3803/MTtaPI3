import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeBoard board = new TicTacToeBoard();
        DB db = new DB();

        boolean isPlayer1Turn = true;
        boolean gameEnded = false;

        while(!gameEnded){
            System.out.println();
            Player X = new Player('X');
            System.out.println("Enter the name of player X: ");
            X.setName(scanner.nextLine());
            System.out.println("Enter the password of player X: ");
            X.setPassword(scanner.nextLine());
            System.out.println();

            if (db.check_player(X.getName(), X.getPassword())) {
                Player O = new Player('O');
                System.out.println("Enter the name of player O: ");
                O.setName(scanner.nextLine());
                System.out.println("Enter the password of player O: ");
                O.setPassword(scanner.nextLine());
                System.out.println();

                if (db.check_player(O.getName(), O.getPassword())) {


        while (!gameEnded) {
            board.printBoard();
            Player currentPlayer = isPlayer1Turn ? X : O;
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
}}
}
}
}