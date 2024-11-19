package org.example.SnakeAndLadder;

import org.example.SnakeAndLadder.Model.Board;
import org.example.SnakeAndLadder.Model.Cell;
import org.example.SnakeAndLadder.Model.Dice;
import org.example.SnakeAndLadder.Model.Player;

import java.util.ArrayDeque;
import java.util.Deque;

public class SnakeAndLadderGame {
    private Board board;
    private Deque<Player> players;
    private Dice dice;
    private Player winner;


    public void gameInit(int cellSize, int snakes, int ladders) {
        board = new Board(cellSize, snakes, ladders);
        dice = new Dice(1);
        addPlayer();
        winner = null;
    }

    private void addPlayer() {
        players = new ArrayDeque<>();
        Player player1 = new Player("PLAYER1", 0);
        Player player2 = new Player("PLAYER2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {

        while(winner == null) {
            //player turn decided
            Player currentPlayer = players.getFirst();
            players.removeFirst();
            players.add(currentPlayer);

            System.out.println("Player turn is : " + currentPlayer.getId() + ", current Position is : " + currentPlayer.getCurrentPosition());
            //roll dice
            int diceNo = dice.rollDice();

            //get new position
            int playerNewPosition = diceNo + currentPlayer.getCurrentPosition();
            playerNewPosition = jumpCheck(playerNewPosition);
            currentPlayer.setCurrentPosition(playerNewPosition);
            System.out.println("Player turn is : " + currentPlayer.getId() + ", new position is : " + playerNewPosition);

            //winner check
            if(playerNewPosition >= board.getCells().length * board.getCells().length - 1) {
                winner = currentPlayer;
            }
        }

        System.out.println("winner is : " + winner.getId());
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.getCells().length * board.getCells().length - 1) {
            return playerNewPosition;
        }

        Cell cellObj = board.getCell(playerNewPosition);
       if(cellObj.getJump() != null && cellObj.getJump().getStart() == playerNewPosition) {
           String jumpBy = cellObj.getJump().getStart() > cellObj.getJump().getEnd() ? "SNAKE" : "LADDER";
           System.out.println("jump done by : " + jumpBy);
           playerNewPosition = cellObj.getJump().getEnd();
       }

       return playerNewPosition;
    }
}
