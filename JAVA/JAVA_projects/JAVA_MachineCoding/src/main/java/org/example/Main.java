package org.example;

import org.example.InMemoryDB.InmemoryDbHelper;
import org.example.SnakeAndLadder.SnakeAndLadderGame;

public class Main {
    public static void main(String[] args) {

        //TIC TAC TOE GAME
//        System.out.println("Game started");
//        Game game = new Game();
//        game.initializeGame();
//
//        System.out.println("Winner is : "  + game.startGame());

        //SNAKE AND LADDER GAME
//        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
//        snakeAndLadderGame.gameInit(10,4,5);
//        snakeAndLadderGame.startGame();


        //inmemory db
        InmemoryDbHelper.InitOperations();
    }
}