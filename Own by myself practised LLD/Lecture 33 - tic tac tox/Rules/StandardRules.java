package Rules;

import java.util.*;

import Engine.Board;
import Model.Symbol;

public class StandardRules implements IRules {

    @Override
    public boolean checkDraw(Board board, int row, int col, Symbol symbol) {

        List<List<Symbol>> grid = board.getGrid();
        int sz = grid.size();

        for(List<Symbol> fir: grid) {
            for(Symbol x: fir) {
                if(x.getSymbol().equals("-")) return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean checkWin(Board board, int row, int col, Symbol symbol) {
        
        List<List<Symbol>> grid = board.getGrid();

        int sz = grid.size();

        boolean won = false;

        //Optiomal method---------------------------------
        int horizontalOccurance = 0;
        int verticalOccurance = 0;
        int diagonalTopLeft = 0;
        int diagonalTopRight = 0;

        for(int i=0;i<sz;i++) {
           
            //horizontal
            if(grid.get(row).get(i).getSymbol().equals(symbol.getSymbol())) {
                horizontalOccurance++ ;
            }

            //vertical
            if(grid.get(i).get(col).getSymbol().equals(symbol.getSymbol())) {
                verticalOccurance++;
            }

            //diagonal from top-left
            if(grid.get(i).get(i).getSymbol().equals(symbol.getSymbol())) {
                diagonalTopLeft++;
            }

            //diagonal from top-right
            if(grid.get(i).get(sz-1-i).getSymbol().equals(symbol.getSymbol())) {
                diagonalTopRight++;
            }            
        }

        if(horizontalOccurance==sz || verticalOccurance==sz || diagonalTopLeft==sz || diagonalTopRight==sz ) won = true;
        if(won) return true;

        return false;
    }

    @Override
    public boolean isValidMove(Board board, int row, int col) {
        return board.getCellEmptyCheck(row, col);
    }
    

}
