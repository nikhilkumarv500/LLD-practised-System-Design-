package Model;

import Piece.Piece;

public class Move {
    
    Position from;
    Position to;
    Piece fromPiece;
    Piece toPiece;

    

    public Move(Position from, Position to, Piece fromPiece, Piece toPiece) {
        this.from = from;
        this.to = to;
        this.fromPiece = fromPiece;
        this.toPiece = toPiece;
    }
    public Position getFrom() {
        return from;
    }
    public void setFrom(Position from) {
        this.from = from;
    }
    public Position getTo() {
        return to;
    }
    public void setTo(Position to) {
        this.to = to;
    }
    public Piece getFromPiece() {
        return fromPiece;
    }
    public void setFromPiece(Piece fromPiece) {
        this.fromPiece = fromPiece;
    }
    public Piece getToPiece() {
        return toPiece;
    }
    public void setToPiece(Piece toPiece) {
        this.toPiece = toPiece;
    }

}
