package Piece;

import java.util.ArrayList;
import java.util.List;

import Board.Board;
import Enum.Color;
import Enum.PieceType;
import Model.Position;

public class PawnPiece extends Piece {

    public PawnPiece(Color color) {
        super(color, PieceType.PAWN, false, "P");
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public List<Position> getPossibleMoves(Position curPos, Board board) {
        
        int curRow = curPos.getRow();
        int curCol = curPos.getCol();

        List<Position> possiblePositionList = new ArrayList<>();

        // front dir one step ----------------------------------------------
        boolean canGoOneStepFurther=false;
        int frontDir = (color == Color.WHITE) ? 1 : -1;

        int newRow = curRow + frontDir;
        int newCol = curCol;

        Position newPosition = new Position(newRow, newCol);

        if(newPosition.isValid() == true) {
            if(board.isPositionEmpty(newPosition) == true) {
                canGoOneStepFurther=true;
                possiblePositionList.add(newPosition);
            }
        }
        // ----------------------------------------------------------

        // front dir two step--------------------------------------
        newRow = curRow + (frontDir*2);
        newCol = curCol;

        newPosition = new Position(newRow, newCol);
        
        if(newPosition.isValid() == true) {
            if(board.isPositionEmpty(newPosition) == true && canGoOneStepFurther==true && hasMoved==false) {
                possiblePositionList.add(newPosition);
            }
        }
        // ----------------------------------------------------------


        // front-left ----------------------------------------------
        newRow = curRow + frontDir;
        newCol = curCol - 1;

        newPosition = new Position(newRow, newCol);
        
        if(newPosition.isValid()) {
            if(board.isPositionEmpty(newPosition)==false && 
                board.isSameColorPawn(newPosition, color)==false) {
                    possiblePositionList.add(newPosition);
            }
        }
        // ----------------------------------------------------------

        
        // front-right ----------------------------------------------
        newRow = curRow + frontDir;
        newCol = curCol + 1;

        newPosition = new Position(newRow, newCol);
        
        if(newPosition.isValid()) {
            if(board.isPositionEmpty(newPosition)==false && 
                board.isSameColorPawn(newPosition, color)==false) {
                    possiblePositionList.add(newPosition);
            }
        }
        // ----------------------------------------------------------


        return possiblePositionList;
    }

    
    
}
