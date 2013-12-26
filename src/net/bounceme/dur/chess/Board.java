package net.bounceme.dur.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private Map<Square, ChessPiece> ps = new HashMap<>();
    private List<ChessPiece> c = new ArrayList<>();

    public Board() {
    }

    void makeSquares() {
        Square square = null;
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                square = new Square(x, y);
            }
        }
    }

    Square getSquare(int i, int i0) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void movePiece(Square startingSquare, Square endingSquare) throws IllegalMove {
        ChessPiece piece = ps.get(startingSquare);
        piece.move(startingSquare, endingSquare);
        if (!(piece instanceof NotRealPiece)) {
            ps.put(startingSquare, new NotRealPiece());
            ChessPiece captured = ps.get(endingSquare);
            if (!(captured instanceof NotRealPiece)) {
                c.add(captured);
            }
            ps.put(endingSquare, piece);
        }
    }
}
