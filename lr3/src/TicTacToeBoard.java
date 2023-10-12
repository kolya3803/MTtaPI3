class TicTacToeBoard {
    private char[][] board;
    private int size = 3;

    public TicTacToeBoard() {
        board = new char[size][size];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean isMoveValid(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ';
    }

    public void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean checkForWin(char symbol) {
        for (int i = 0; i < size; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true; // Check rows
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true; // Check columns
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true; // Check diagonal (top-left to bottom-right)
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true; // Check diagonal (top-right to bottom-left)
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}