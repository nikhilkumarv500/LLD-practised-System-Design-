package Model;

public class Position {
    int row;
    int col;

    public Position(int x, int y) {
        this.row=x;
        this.col=y;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isValid() {
        if(row<0 || row>=8 || col<0 || col>=8) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Position [row=" + row + ", col=" + col + "]\n";
    }

    

}
