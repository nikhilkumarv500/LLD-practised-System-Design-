package Piece;

import Enum.Color;
import Enum.PieceType;
import Model.Position;

import java.util.*;

import Board.Board;

public abstract class Piece {
    Color color;
    PieceType pieceType;
    boolean hasMoved;
    String symbol;

    public Piece(Color color, PieceType pieceType, boolean hasMoved, String symbol) {
        this.color=color;
        this.pieceType=pieceType;
        this.hasMoved=hasMoved;
        this.symbol=symbol;
    }

    public abstract List<Position> getPossibleMoves(Position curPos, Board board);
    public abstract PieceType getPieceType();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public String getSymbol() {
        return (color == Color.BLACK ? "B" : "W") + symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    
    
}
