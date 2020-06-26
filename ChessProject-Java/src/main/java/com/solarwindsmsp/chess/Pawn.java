package com.solarwindsmsp.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {

        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if(chessBoard.isLegalBoardPosition(newX, newY) && isPawnAllowedToMove(newY,movementType)){
            yCoordinate = newY;
        }
    }

    private boolean isPawnAllowedToMove(int newY, MovementType movementType) {
        return ((pieceColor.equals(PieceColor.BLACK) && newY == yCoordinate - 1)
        || (pieceColor.equals(PieceColor.WHITE) && newY == yCoordinate + 1))
        && movementType.equals(MovementType.MOVE);
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        return "Current X: " + xCoordinate + " Current Y: " + yCoordinate + "Piece Color: " + pieceColor;
    }
}
