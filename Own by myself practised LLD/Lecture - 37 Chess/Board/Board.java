package Board;

import Model.Move;
import Model.Position;
import Piece.*;

import java.util.*;

import Enum.Color;
import Enum.PieceType;

public class Board {
    Piece [][] grid = new Piece[8][8];
    Map<String, Piece> position_piece_map = new HashMap<>();

    public boolean isPositionEmpty(Position position) {
        String key = position.getRow()+ "_"+ position.getCol();
        return position_piece_map.containsKey(key)==false;
    }

    public boolean isSameColorPawn(Position position,Color color) {
        String key = position.getRow() + "_" + position.getCol();
        if(isPositionEmpty(position)==true) return false;

        Piece alreadyExisitingPiece = position_piece_map.get(key);
        // System.out.println(alreadyExisitingPiece.getSymbol());
        // System.out.println(key + " | " + color);

        return alreadyExisitingPiece.getColor() == color;
        // return true;
    }

    public Piece getPieceWithRowCol(int row, int col) {
        return grid[row][col];
    }

    public Piece getPieceByPosition(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();
        return getPieceWithRowCol(row, col);
    }

    public void removePawn(int row, int col) {
        String key = row + "_" + col;

        grid[row][col]=null;
        if(position_piece_map.containsKey(key)) position_piece_map.remove(key);
    }

    public void placePawn(int row, int col, Piece piece) {
        String key = row + "_" + col;

        grid[row][col]=piece;
        if(piece!=null){
            // piece.setHasMoved(true);
             position_piece_map.put(key, piece);
        }
    }

    public void movePawn(Move move) {
        
        String curPieceKey = move.getFrom().getRow() + "_" + move.getFrom().getCol();
        if(position_piece_map.containsKey(curPieceKey)) position_piece_map.remove(curPieceKey);

        String toPieceKey = move.getTo().getRow() + "_" + move.getTo().getCol();
        if(position_piece_map.containsKey(toPieceKey)) position_piece_map.remove(toPieceKey);

        removePawn(move.getFrom().getRow(), move.getFrom().getCol());
        placePawn(move.getTo().getRow(), move.getTo().getCol(), move.getFromPiece());
        move.getFromPiece().setHasMoved(true);

    }

    public Position getPositionByPieceType_color(Color color, PieceType pieceType) {

        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                Piece curPiece = grid[i][j]; 

                if(curPiece==null) continue;

                if(curPiece.getColor()==color && curPiece.getPieceType()==pieceType) {
                    return new Position(i, j);
                }
            }
        }

        return null;
    }

    public Piece getPieceByPieceType(Color color, PieceType pieceType) {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                Piece curPiece = grid[i][j]; 

                if(curPiece==null) continue;

                if(curPiece.getColor()==color && curPiece.getPieceType()==pieceType) {
                    return curPiece;
                }
            }
        }

        return null;
    }

    public List<Position> getAllPawnPositionByColor(Color color) {

        List<Position> arr = new ArrayList<>();

        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if(grid[i][j]!=null && grid[i][j].getColor()==color) {
                    arr.add(new Position(i, j));
                }
            }
        }

        return arr;
    }

    public void initializeBoard() {

        // add white ----------------------------------
        Piece wRookL = new RookPiece(Color.WHITE);
        Piece wKnightL = new KnightPiece(Color.WHITE);
        Piece wBishopL = new BishopPiece(Color.WHITE);
        Piece wKing = new KingPiece(Color.WHITE);
        Piece wQueen = new QueenPiece(Color.WHITE);
        Piece wBishopR = new BishopPiece(Color.WHITE);
        Piece wKnightR = new KnightPiece(Color.WHITE);
        Piece wRookR = new RookPiece(Color.WHITE);

        placePawn(0,0,wRookL);
        placePawn(0,1,wKnightL);
        placePawn(0,2,wBishopL);
        placePawn(0,3,wQueen);
        placePawn(0,4,wKing);
        placePawn(0,5,wBishopR);
        placePawn(0,6,wKnightR);
        placePawn(0,7,wRookR);

        for(int i=0;i<8;i++) {
            placePawn(1,i,new PawnPiece(Color.WHITE));
        }

        //add black ----------------------------------
        Piece bRookL = new RookPiece(Color.BLACK);
        Piece bKnightL = new KnightPiece(Color.BLACK);
        Piece bBishopL = new BishopPiece(Color.BLACK);
        Piece bKing = new KingPiece(Color.BLACK);
        Piece bQueen = new QueenPiece(Color.BLACK);
        Piece bBishopR = new BishopPiece(Color.BLACK);
        Piece bKnightR = new KnightPiece(Color.BLACK);
        Piece bRookR = new RookPiece(Color.BLACK);

        placePawn(7,0,bRookL);
        placePawn(7,1,bKnightL);
        placePawn(7,2,bBishopL);
        placePawn(7,3,bQueen);
        placePawn(7,4,bKing);
        placePawn(7,5,bBishopR);
        placePawn(7,6,bKnightR);
        placePawn(7,7,bRookR);

        for(int i=0;i<8;i++) {
            placePawn(6,i,new PawnPiece(Color.BLACK));
        }

    }

    public void printBoard() {

        for(int i=0;i<=8;i++) {
            for(int j=0;j<=8;j++) {

                if(i==0) {
                    if(j==0) {
                        System.out.print("      ");
                        continue;
                    };
                    System.out.print( "0"+ (j-1) + "    ");
                    continue;
                } 
                if(j==0) {
                    System.out.print( "0"+ (i-1) + "    ");
                    continue;
                }

                Piece curPiece = grid[i-1][j-1];

                if(curPiece==null) {
                    System.out.print("--    ");
                } else {
                    System.out.print(curPiece.getSymbol() + "    ");
                }
            }
            System.out.println();
            System.out.println();
        }

        // System.out.println(position_piece_map);

    }



}   
