import java.util.Scanner;
class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int makeMove(String message) {
        Scanner scanner = new Scanner(System.in);
        int move;
        while (true) {
            try {
                System.out.print(message);
                move = scanner.nextInt() - 1;
                if (move >= 0 && move <= 2) {
                    break;
                } else {
                    System.out.println("Please enter a valid number (1-3).");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number (1-3).");
                scanner.next();
            }
        }
        return move;
    }
}