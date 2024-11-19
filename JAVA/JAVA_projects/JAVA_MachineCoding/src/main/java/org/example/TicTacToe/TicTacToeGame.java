package org.example.TicTacToe;

import javafx.util.Pair;
import lombok.Data;
import org.example.TicTacToe.Model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

@Data
public class TicTacToeGame {
    private Board gameBoard;
    private Deque<Player> playerList;


    public void initializeGame(){
        //initialize board
        gameBoard = new Board(3);


        //initialize players
        playerList = new ArrayDeque<>();
        Player player1 = new Player("player1", new PlayingPieceX());
        Player player2 = new Player("player2", new PlayingPieceO());
        playerList.add(player1);
        playerList.add(player2);
    }

    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            Player currentplayer = playerList.getFirst();
            playerList.removeFirst();

            //print board
            gameBoard.printBoard();

            //Tie check
            List< Pair<Integer, Integer> > freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }

            //read user input
            System.out.println("Player : " + currentplayer.getName() + "Enter (row,col) ");
            Scanner sc = new Scanner(System.in);
            String rowCol = sc.nextLine();
            String[]  values = rowCol.split(",");
            Integer row = Integer.valueOf(values[0]);
            Integer col = Integer.valueOf(values[1]);



            boolean pieceAddSuccessfully = gameBoard.addPiece(currentplayer.getPlayingPiece(), row, col);

            if(!pieceAddSuccessfully) {
                System.out.println("Invalied input try again");
                playerList.addFirst(currentplayer);
                continue;
            }

            playerList.add(currentplayer);

            if(checkWinner(currentplayer, row, col)) {
                return currentplayer.getName();
            }


        }

        return "tie";
    }

    private boolean checkWinner(Player currentplayer, Integer row, Integer col) {
        boolean rowFlag = true;
        boolean colFlag = true;
        boolean diagFlag = true;
        boolean antidiagFlag = true;

        //row
        for(int j = 0; j< gameBoard.getSize(); j++) {
            if( gameBoard.board[row][j] == null || gameBoard.board[row][j].getPieceType() != currentplayer.getPlayingPiece().getPieceType()) {
                rowFlag = false;
            }
        }

        //column
        for(int i = 0;  i < gameBoard.getSize(); i++) {
            if( gameBoard.board[i][col] == null || gameBoard.board[i][col].getPieceType() != currentplayer.getPlayingPiece().getPieceType()) {
                colFlag = false;
            }
        }

        //diagonal
        for(int i = 0, j = 0;  i < gameBoard.getSize(); i++, j++) {
            if( gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != currentplayer.getPlayingPiece().getPieceType()) {
                diagFlag = false;
            }
        }

        //antidiagonal
        for(int i = 0, j = gameBoard.getSize() - 1;  i < gameBoard.getSize(); i++, j--) {
            if( gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != currentplayer.getPlayingPiece().getPieceType()) {
                antidiagFlag = false;
            }
        }

        return rowFlag | colFlag | diagFlag | antidiagFlag;
    }
}
