package Rules;

import Engine.Board;
import Model.Symbol;

public interface IRules {
    boolean isValidMove(Board board,int row, int col);
    boolean checkWin(Board board, int row, int col, Symbol symbol);
    boolean checkDraw(Board board, int row, int col, Symbol symbol);
}
