import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    private int tileSize = 100;
    private int cols = 8;
    private int rows = 8;

    private ArrayList<Piece> pieceList = new ArrayList<>();

    private Piece selectedPiece;
    private Input input = new Input(this);

    Board(){
        this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));

        this.addMouseListener(input);
        this.addMouseMotionListener(input);

        addPieces();
    }

    public Piece getPiece(int row, int col){

        for(Piece piece : pieceList){
            if(piece.getCol() == col && piece.getRow() == row){
                return piece;
            }
        }

        return null;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public ArrayList<Piece> getPieceList() {
        return pieceList;
    }

    public void setPieceList(ArrayList<Piece> pieceList) {
        this.pieceList = pieceList;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public void addPieces(){
        //red pieces

        pieceList.add(new Piece(this, 5, 0, true));
        pieceList.add(new Piece(this, 5, 2, true));
        pieceList.add(new Piece(this, 5, 4, true));
        pieceList.add(new Piece(this, 5, 6, true));
        pieceList.add(new Piece(this, 6, 1, true));
        pieceList.add(new Piece(this, 6, 3, true));
        pieceList.add(new Piece(this, 6, 5, true));
        pieceList.add(new Piece(this, 6, 7, true));
        pieceList.add(new Piece(this, 7, 0, true));
        pieceList.add(new Piece(this, 7, 2, true));
        pieceList.add(new Piece(this, 7, 4, true));
        pieceList.add(new Piece(this, 7, 6, true));

        //black pieces
        pieceList.add(new Piece(this, 0, 1, false));
        pieceList.add(new Piece(this, 0, 3, false));
        pieceList.add(new Piece(this, 0, 5, false));
        pieceList.add(new Piece(this, 0, 7, false));
        pieceList.add(new Piece(this, 1, 0, false));
        pieceList.add(new Piece(this, 1, 2, false));
        pieceList.add(new Piece(this, 1, 4, false));
        pieceList.add(new Piece(this, 1, 6, false));
        pieceList.add(new Piece(this, 2, 1, false));
        pieceList.add(new Piece(this, 2, 3, false));
        pieceList.add(new Piece(this, 2, 5, false));
        pieceList.add(new Piece(this, 2, 7, false));
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                g2d.setColor((i + j) % 2 == 0 ? new Color(227, 198, 181) : new Color(157,105,53));
                g2d.fillRect(j * this.tileSize, i * this.tileSize, this.tileSize, this.tileSize);
            }
        }

        for(Piece piece : pieceList){
            piece.paint(g2d);
        }
    }

    public void makeMove(Move move){
        move.getPiece().setCol(move.getNewCol());
        move.getPiece().setRow(move.getNewRow());
        move.getPiece().setxPos(move.getNewCol() * tileSize);
        move.getPiece().setyPos(move.getNewRow() * tileSize);

        capture(move);
    }

    public void capture(Move move){
        pieceList.remove(move.getCapture());
    }

    public boolean sameTeam(Piece p1, Piece p2){
        if(p1 == null || p2 == null){
            return false;
        }

        return p1.isRed() == p2.isRed();
    }

    public boolean isValidMove(Move move){
        if(sameTeam(move.getPiece(), move.getCapture()) || move.getPiece().getxPos() < -53 || move.getPiece().getxPos() > 745 || move.getPiece().getyPos() < -53 || move.getPiece().getyPos() > 745){
            return false;
        }

        return true;
    }
}
