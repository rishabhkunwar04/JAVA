package org.example.TicTacToe.Model;

import javafx.util.Pair;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    public PlayingPiece [][] board;
    private int size;


    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(PlayingPiece playingPiece, int row, int col) {
        if(row < 0 || col < 0 || row >= size || col >= size || board[row][col] != null) {
            return false;
        }

        board[row][col] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            for(int j=0;j< board[i].length ; j++) {
                if(board[i][j] == null) {
                    freeCells.add(new Pair<Integer, Integer>(i,j));
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for(int i=0;i< board.length; i++) {
            for(int j=0; j< board[i].length; j++) {
                if(board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType().name() + "  ");
                } else {
                    System.out.print("   ");
                }

                System.out.print(" | ");
            }

            System.out.println();
        }
    }

}
