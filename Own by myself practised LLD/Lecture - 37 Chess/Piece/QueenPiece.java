package Piece;

import java.util.ArrayList;
import java.util.List;

import Board.Board;
import Enum.Color;
import Enum.PieceType;
import Model.Position;

public class QueenPiece extends Piece{
    
    public QueenPiece(Color color) {
        super(color, PieceType.QUEEN, false, "Q");
    }

    @Override
    public List<Position> getPossibleMoves(Position curPos, Board board) {
        int curRow = curPos.getRow();
        int curCol = curPos.getCol();

        List<Position> possiblePositionList = new ArrayList<>();

        int dir[][] = {{-1,-1}, {-1,1}, {1,-1}, {1,1}, {0,-1}, {0,1}, {-1,0}, {1,0}};

        for(int i=0;i<dir.length;i++) {
            
            for(int cont=1;cont<=8;cont++) {

                int new_row = curRow + dir[i][0] * cont;
                int new_col = curCol + dir[i][1] * cont;
                
                Position newPosition = new Position(new_row, new_col);
                if(!newPosition.isValid()) break;

                if(board.isPositionEmpty(newPosition) == false) {
                    if(board.isSameColorPawn(newPosition, color) == true) {
                        break;
                    }
                    possiblePositionList.add(newPosition);
                    break;
                }

                possiblePositionList.add(newPosition);

            }
        }

        return possiblePositionList;
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

}
