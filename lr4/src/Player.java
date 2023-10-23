import java.util.Scanner;
class Player {
    private String name;
    private char symbol;
    private String password;

    public Player(char symbol) {
        this.symbol = symbol;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
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