package Design_questions.ticTacToe;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    Board board;
    private  Player currentPlayer ;
    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        board=new Board();
        this.currentPlayer = player1;
    }

    public void Play(){
        System.out.println("Print Board");
        board.isFull();

        while(!board.hasWinner() && !board.isFull()){
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter column (0-2): ");

            try {
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();
                currentPlayer= switchPlayer(currentPlayer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (board.hasWinner()) {
            currentPlayer= switchPlayer(currentPlayer);
            System.out.println(currentPlayer.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }


    }

    public Player switchPlayer(Player currentPlayer){
        return  currentPlayer==player1?player2:player1;
    }
    // enter console  input
    public int getValidInput(String msg){
        System.out.println(msg);
        Scanner scanner=new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n >= 0 && n <= 2) {
                return n;
            } else {
                System.out.println("Invalid input! Please enter a number between 0 and 2.");
            }
        }
    }


}
