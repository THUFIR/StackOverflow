package net.bounceme.dur.chess;

public class Main {

    public Main() {
        playChess();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void playChess() {

        Board board = new Board();
        board.makeSquares();
        System.out.println(board);
        Square startingSquare = board.getSquare(3, 1);  //   0<=x<=7, 0<=y<=7  (file, rank)
        Square endingSquare = board.getSquare(3, 5);  //illegal move
        ChessPiece pawn = startingSquare.getPiece();  //assumes a pawn is at that square...
        System.out.println(pawn.toString());
        try {
            board.movePiece(startingSquare, endingSquare);
        } catch (IllegalMove ex) {
            System.out.println(ex);  //only allow legal moves, print error
        }
        System.out.println(board);
    }
}
