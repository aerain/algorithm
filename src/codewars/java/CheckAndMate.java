package codewars.java;

import java.util.HashSet;
import java.util.Set;

public class CheckAndMate {
    public static Set<PieceConfig> isCheck(final PieceConfig[] arrPieces, int player) {

        return new HashSet<>();
//        throw new RuntimeException("Not implemented yet!");
    }

    public static boolean isMate(final PieceConfig[] arrPieces, int player) {
        throw new RuntimeException("Not implemented yet!");
    }
}

class PieceConfig {
    private String piece;
    private int owner, x, y, prevX, prevY;

    public PieceConfig(final String piece, final int owner, final int x, final int y, final int prevX, final int prevY) {
    }

    public PieceConfig(final String piece, final int owner, final int x, final int y) {
    }

    public String getPiece() {
        return piece;
    }

    public int getOwner() {
        return owner;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasPrevious() {
        return true;
    }

    public int getPrevX() {
        return prevX;
    }        // will throw a RuntimeException if invoked for an object that do not have informations about its previous move.

    public int getPrevY() {
        return prevY;
    }       // will throw a RuntimeException if invoked for an object that do not have informations about its previous move.

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "hi";
    } //return string formated as :"piece: king, owner: 0, x: 0, y: 4" (plus prevX and prevY if needed)

    @Override
    public boolean equals(Object other) {
        return true;
    }
}