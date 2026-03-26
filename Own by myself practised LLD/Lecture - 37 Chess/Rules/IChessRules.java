package Rules;

import Board.Board;
import Enum.Color;
import Model.Move;

public interface IChessRules {
    boolean isValidMove(Move move, Board board);
    boolean isInCheck(Color color, Board board);
    boolean isCheckMate(Color color, Board board);
    boolean isStaleCheck(Color color, Board board);
}
