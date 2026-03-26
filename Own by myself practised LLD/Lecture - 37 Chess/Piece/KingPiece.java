package Piece;

import java.util.ArrayList;
import java.util.List;

import Board.Board;
import Enum.Color;
import Enum.PieceType;
import Model.Position;

public class KingPiece extends Piece {

    public KingPiece(Color color) {
        super(color, PieceType.KING, false, "K");
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public List<Position> getPossibleMoves(Position curPos, Board board) {

        List<Position> possibleMovesList = new ArrayList<>();
        
        int dir[][] = {{-1,-1}, {-1,1}, {1,-1}, {1,1}, {0,-1}, {0,1}, {-1,0}, {1,0}};

        for(int i=0;i<dir.length;i++) {

            int newRow = curPos.getRow() + dir[i][0];
            int newCol = curPos.getCol() + dir[i][1];

            Position newPosition = new Position(newRow, newCol);

            if(newPosition.isValid() == false) continue;

            if(board.isSameColorPawn(newPosition, color) == true) {
                continue;
            }

            possibleMovesList.add(newPosition);

        }

        return possibleMovesList;
    }
    
    

}
