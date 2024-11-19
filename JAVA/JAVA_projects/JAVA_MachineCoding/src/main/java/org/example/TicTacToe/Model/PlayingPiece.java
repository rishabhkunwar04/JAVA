package org.example.TicTacToe.Model;

import lombok.Data;

@Data
public class PlayingPiece {
    private PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
