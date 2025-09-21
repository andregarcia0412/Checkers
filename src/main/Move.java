public class Move {

    private int oldCol;
    private int oldRow;

    private int newCol;
    private int newRow;

    private Piece piece;
    private Piece capture;

    Move(Board board, Piece piece, int newRow, int newCol){

         this.oldCol = piece.getCol();
         this.oldRow = piece.getRow();
         this.newCol = newCol;
         this.newRow = newRow;

         this.piece = piece;
         this.capture = piece.getBoard().getPiece(newRow, newCol);

    }

    public int getOldCol() {
        return oldCol;
    }

    public void setOldCol(int oldCol) {
        this.oldCol = oldCol;
    }

    public int getOldRow() {
        return oldRow;
    }

    public void setOldRow(int oldRow) {
        this.oldRow = oldRow;
    }

    public int getNewCol() {
        return newCol;
    }

    public void setNewCol(int newCol) {
        this.newCol = newCol;
    }

    public int getNewRow() {
        return newRow;
    }

    public void setNewRow(int newRow) {
        this.newRow = newRow;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getCapture() {
        return capture;
    }

    public void setCapture(Piece capture) {
        this.capture = capture;
    }
}
