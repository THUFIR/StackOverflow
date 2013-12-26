/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bounceme.dur.chess;

/**
 *
 * @author thufir
 */
class NotRealPiece implements ChessPiece {

    public NotRealPiece() {
    }

    @Override
    public void move(Square startingSquare, Square endingSquare) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
