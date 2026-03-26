package Rules;

import java.util.ArrayList;
import java.util.List;

import Board.Board;
import Enum.Color;
import Enum.PieceType;
import Model.Move;
import Model.Position;
import Piece.Piece;

public class StandardRule implements IChessRules {

    @Override
    public boolean isValidMove(Move move, Board board) {
        
        int curRow = move.getFrom().getRow();
        int curCol = move.getFrom().getCol();
        Position curPos = move.getFrom();
        Piece curPiece = move.getFromPiece();
        Color curColor = curPiece.getColor();

        int toRow = move.getTo().getRow();
        int toCol = move.getTo().getCol();
        Position toPos = move.getTo();
        Piece toPiece = move.getToPiece();

        //check is a pawn-of-same-color already exists -------------------------------
        if(board.isPositionEmpty(move.getTo()) == false) {
            if(board.isSameColorPawn(toPos, curColor) == true) {
                return false;
            }
        }

        //check is desierd move exists in possible move of that pawn -----------------
        List<Position> possiblePawnMoves = board.getPieceByPosition(curPos).getPossibleMoves(curPos, board);
        boolean assumeCanMove = false;

        for(Position x: possiblePawnMoves) {
            if(x.getRow()==toRow && x.getCol()==toCol) {
                assumeCanMove=true;
                break;
            }
        }
        if(assumeCanMove==false) return false;


        //check on applying that move leads to self check --------------------------
        boolean onMoveCheck = onMoveApply_IsCheck(move, board);

        return (onMoveCheck==false);
    }

    public boolean onMoveApply_IsCheck(Move move, Board board) {

        Color curColor = move.getFromPiece().getColor();

        Position curPiecePos = move.getFrom();
        Piece curPiece = move.getFromPiece();

        Position toPiecePos = move.getTo();
        Piece toPiece = move.getToPiece();

        board.movePawn(move);

        boolean onMoveIsCheck = isInCheck(curColor, board);

        board.removePawn(curPiecePos.getRow(), curPiecePos.getCol());
        board.removePawn(toPiecePos.getRow(),toPiecePos.getCol());

        board.placePawn(curPiecePos.getRow(), curPiecePos.getCol(), curPiece);
        board.placePawn(toPiecePos.getRow(),toPiecePos.getCol(), toPiece);
        
        return onMoveIsCheck;
    }

    @Override
    public boolean isInCheck(Color color, Board board) {

        // System.out.println("isincheck");
        
        Position curKingPosition = board.getPositionByPieceType_color(color, PieceType.KING);

        List<Position> allOpponenets_PawnPositions = board.getAllPawnPositionByColor((color == Color.WHITE) ? Color.BLACK : Color.WHITE);
        List<Position> allOppo_PossiblePawnPositions = new ArrayList<>();

        for(Position x: allOpponenets_PawnPositions) {
            Piece curPiece = board.getPieceByPosition(x);
            List<Position> temp = curPiece.getPossibleMoves(x, board);
            // System.out.println(temp);
            allOppo_PossiblePawnPositions.addAll(temp);
        }

        for(Position x: allOppo_PossiblePawnPositions) {
            if(x.getRow()==curKingPosition.getRow() && x.getCol()==curKingPosition.getCol()) {
                return true;
            }
        }
        // System.out.println("isincheck");

        return false;
    }

    @Override
    public boolean isCheckMate(Color color, Board board) {
        boolean isInCheck_atPresent = isInCheck(color, board);

        if(isInCheck_atPresent==false) return false;
        // System.out.println("ksfdjsdjhbnjhff bjnrnbvrsjrhvbsjhrvskrjhv");
        

        Position curKingPos = board.getPositionByPieceType_color(color, PieceType.KING);

        List<Position> allCurKings_possibleMove = board.getPieceByPieceType(color, PieceType.KING).getPossibleMoves(curKingPos, board);

        List<Position> allOpponenets_PawnPositions = board.getAllPawnPositionByColor((color == Color.WHITE) ? Color.BLACK : Color.WHITE);
        List<Position> allOppo_PossiblePawnPositions = new ArrayList<>();
        for(Position x: allOpponenets_PawnPositions) {
            Piece curPiece = board.getPieceByPosition(x);
            List<Position> temp = curPiece.getPossibleMoves(x, board);
            allOppo_PossiblePawnPositions.addAll(temp);
        }

        for(Position possibleCurKing : allCurKings_possibleMove) {
            boolean canEscape = true;

            for(Position possibleOpp : allOppo_PossiblePawnPositions) {
                if(possibleCurKing.getRow()==possibleOpp.getRow() && possibleCurKing.getCol()==possibleOpp.getCol()) {
                    canEscape = false;
                    break;
                }
            }

            if(canEscape==true) return false;
        }

        return true;
    }

    @Override
    public boolean isStaleCheck(Color color, Board board) {
        boolean isInCheck_atPresent = isInCheck(color, board);

        if(isInCheck_atPresent==true) return false;

        Position curKingPos = board.getPositionByPieceType_color(color, PieceType.KING);

        List<Position> allCurKings_possibleMove = board.getPieceByPieceType(color, PieceType.KING).getPossibleMoves(curKingPos, board);

        List<Position> allOpponenets_PawnPositions = board.getAllPawnPositionByColor((color == Color.WHITE) ? Color.BLACK : Color.WHITE);
        List<Position> allOppo_PossiblePawnPositions = new ArrayList<>();
        for(Position x: allOpponenets_PawnPositions) {
            Piece curPiece = board.getPieceByPosition(x);
            List<Position> temp = curPiece.getPossibleMoves(x, board);
            allOppo_PossiblePawnPositions.addAll(temp);
        }

        for(Position possibleCurKing : allCurKings_possibleMove) {
            boolean canEscape = true;

            for(Position possibleOpp : allOppo_PossiblePawnPositions) {
                if(possibleCurKing.getRow()==possibleOpp.getRow() && possibleCurKing.getCol()==possibleOpp.getCol()) {
                    canEscape = false;
                    break;
                }
            }

            if(canEscape==true) return false;
        }

        return true;
    }

    

    
    
}
