package org.example.SnakeAndLadder.Model;

import lombok.Data;

import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class Board {
    private  Cell [][] cells;

   public Board(int cellSize, int snakes, int ladders) {
       cells = new Cell[cellSize][cellSize];
       initializeBoard(cellSize);
       addSnakeAndLadders(snakes, ladders);
   }

    private void addSnakeAndLadders(int snakes, int ladders) {

       while(snakes > 0) {
           int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length -1);
           int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length -1);

           if(snakeHead <= snakeTail) {
               continue;
           }

           Jump jump = new Jump();
           jump.setStart(snakeHead);
           jump.setEnd(snakeTail);

           Cell cellObj = getCell(snakeHead);
           cellObj.setJump(jump);
           snakes --;
       }

        while(ladders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length -1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length -1);

            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump jump = new Jump();
            jump.setStart(ladderStart);
            jump.setEnd(ladderEnd);

            Cell cellObj = getCell(ladderStart);
            cellObj.setJump(jump);
            ladders --;
        }
    }

    public Cell getCell(int snakeHead) {
       int row = snakeHead / cells.length;
       int col = snakeHead % cells.length;

       return cells[row][col];
    }

    private void initializeBoard(int cellSize) {
        for(int i=0; i<cellSize ; i++) {
            for(int j=0;j<cellSize; j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

}

