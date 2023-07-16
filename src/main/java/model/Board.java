package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class Board {

    private static ArrayList<Square> squares;

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public Board(){
        squares = new ArrayList<>();
    }
    // Getter ---- -----------------------------------------------------------------------------------------------------
    public static ArrayList<Square> getSquares(){
        return squares;
    }

    // Other Methods ---------------------------------------------------------------------------------------------------
    public Square addSquare(String squareName, int row, int col, Color color) throws BoardException {
        Square newSquare = new Square(squareName, row, col, color , new Rectangle(90,90));
        squares.add(newSquare);
        return newSquare;
    }

    // toString --------------------------------------------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append("---------------------------------\n");
        for (int row = 8; row > 0; row --){
            for (int col = 1; col < 9; col++) {
                for (Square s : Board.getSquares()) {
                    if (s.getRow() == row && s.getCol() == col) {
                        if (!s.isOccupied())
                            sb.append("| " + "  ");
                        else
                            sb.append("| ").append(s.getPiece().getPieceName()).append(" ");

                    }
                }
            }
            sb.append("|");
            sb.append("\n---------------------------------\n");
        }

        return sb.toString();
    }
    public void print(){
        System.out.println(this);
    }
}