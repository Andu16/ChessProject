package com.solarwindsmsp.chess;

public class ChessBoard {

    public static final int MAX_BOARD_COORDINATE = 7;
    public static final int BOARD_SIDE = 8;
    public static final int MIN_BOARD_COORDINATE = 0;
    public static final int BLACK_PAWN_INITIAL_ROW = 6;
    public static final int WHITE_PAWN_INITIAL_ROW = 1;
    public static final int OUTSIDE_COORDINATE = -1;


    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_SIDE][BOARD_SIDE];

    }

    //Magic! Do not touch!
    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        pawn.setPieceColor(pieceColor);

        if(isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null
        && isPawnAddRow(xCoordinate, pieceColor)){
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);

            pieces[xCoordinate][yCoordinate] = pawn;
            pawn.setChessBoard(this);
        }
        else{
            pawn.setXCoordinate(OUTSIDE_COORDINATE);
            pawn.setYCoordinate(OUTSIDE_COORDINATE);
        }
    }

    private boolean isPawnAddRow(int xCoordinate, PieceColor pieceColor) {
        return (pieceColor.equals(PieceColor.BLACK) && xCoordinate == BLACK_PAWN_INITIAL_ROW)
                || (pieceColor.equals(PieceColor.WHITE) && xCoordinate == WHITE_PAWN_INITIAL_ROW);
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= MIN_BOARD_COORDINATE && xCoordinate <= MAX_BOARD_COORDINATE
                && yCoordinate >= MIN_BOARD_COORDINATE && yCoordinate <= MAX_BOARD_COORDINATE;
    }
}
