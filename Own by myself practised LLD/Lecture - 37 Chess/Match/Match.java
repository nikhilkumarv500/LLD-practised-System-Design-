package Match;

import java.nio.file.attribute.PosixFileAttributeView;

import Board.Board;
import Enum.Color;
import Model.Move;
import Model.Position;
import Model.User;
import Rules.IChessRules;
import Rules.StandardRule;

public class Match {

    User whiteUser, blackUser;
    IChessRules chessRule;
    Board board;
    boolean isWhiteTurn = true;


    public Match(User u1, User u2) {
        whiteUser=u1;
        blackUser=u2;
        chessRule = new StandardRule();

        board = new Board();
        board.initializeBoard();
    }

    public boolean makeMove(Position fromPos, Position toPos) {

        if(board.getPieceByPosition(fromPos) == null) {
            System.out.println("Your have not selected any pawn");
            return false;
        }

        Color cuColor = board.getPieceByPosition(fromPos).getColor();

        if((isWhiteTurn==true && cuColor==Color.BLACK) || (isWhiteTurn==false && cuColor==Color.WHITE)) {
            System.out.println("You have choosen wrong color pawn");
            return false;
        }

        Move move = new Move(fromPos, toPos, board.getPieceByPosition(fromPos), board.getPieceByPosition(toPos));

        if(chessRule.isValidMove(move, board) == false) {
            System.out.println("Either invalid move or move leads to your check");
            return false;
        }

        board.movePawn(move);

        return true;    

    }

    public void changeUserTurn() {
        isWhiteTurn = !isWhiteTurn;
    }

    public User checkWhichUsersTurn() {
        if(isWhiteTurn) return whiteUser;
        else return blackUser;
    }

    public Color getCurUserTurnColor() {
        if(isWhiteTurn) return Color.WHITE;
        return Color.BLACK;
    }

    public boolean checkMateFromCurPlayer() {
        return chessRule.isCheckMate(isWhiteTurn ? Color.BLACK : Color.WHITE, board);
    }

    public boolean staleMateFromCurPlayer() {
        return chessRule.isCheckMate(isWhiteTurn ? Color.BLACK : Color.WHITE, board);
    }

    public void printBoard() {
        board.printBoard();
    }

    
}
