package Engine;

import java.util.*;

import Model.Symbol;

public class Board {
    int sz;
    List<List<Symbol>> grid = new ArrayList<>();
    // Symbol[][] grid;
    String EmptySymbol = "-";

    

    public Board(int sz) {
        this.sz=sz;

        // grid = new Symbol[sz][sz];

        for(int i=0;i<sz;i++) {
            grid.add(new ArrayList<>());
            for(int j=0;j<sz;j++) {
                grid.get(i).add(new Symbol(EmptySymbol));
            }
        }

    }


    public boolean getCellEmptyCheck(int row, int col) {
        if(row<0 || row>=sz || col<0 || col>=sz) return false;
        return getSymbolFromGrid(row, col).getSymbol().equals(EmptySymbol);
    }

    public boolean placeMarkOnBoard(int row, int col, Symbol symbol) {
        if(getCellEmptyCheck(row, col)) {
            putSymbolIntoGrid(row, col, symbol);
            return true;
        }
        return false;
    }



    public List<List<Symbol>> getGrid(){
        return grid;
    }


    public void printBoard() {

        for(List<Symbol> list: grid) {
            for(Symbol symbol : list) {
                System.out.print(symbol.getSymbol() + " ");
            }
            System.out.println();
        }

    }







    // --------------------------------------------------
    public Symbol getSymbolFromGrid(int row,int col) {
        // return grid[row][col]
        return grid.get(row).get(col);
    }

    public void putSymbolIntoGrid(int row, int col, Symbol symbol) {
        // grid[row][col]=symbol;
        grid.get(row).set(col, symbol);
    }



}
