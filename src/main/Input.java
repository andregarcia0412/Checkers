import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.InputStream;

public class Input extends MouseAdapter {

    private Board board;
    private Audio moveSelfAudio;
    private Audio notifyAudio;

    Input(Board board){
        this.board = board;

        InputStream moveSound = getClass().getResourceAsStream("/move-self.wav");
        InputStream notifySound = getClass().getResourceAsStream("/notify.wav");

        this.moveSelfAudio = new Audio(moveSound);
        this.notifyAudio = new Audio(notifySound);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / board.getTileSize();
        int row = e.getY() / board.getTileSize();
        Piece pieceXY = board.getPiece(row, col);
        if(pieceXY != null){
            board.setSelectedPiece(pieceXY);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.getTileSize();
        int row = e.getY() / board.getTileSize();


        if(board.getSelectedPiece() != null){
            Move move = new Move(board, board.getSelectedPiece(), row, col);

            if(board.isValidMove(move)){
                board.makeMove(move);
                moveSelfAudio.play();
            } else{
                board.getSelectedPiece().setxPos(move.getOldCol() * board.getTileSize());
                board.getSelectedPiece().setyPos(move.getOldRow() * board.getTileSize());
                notifyAudio.play();
            }
        }
        board.setSelectedPiece(null);
        board.repaint();
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        if(board.getSelectedPiece() != null){
            board.getSelectedPiece().setxPos(e.getX() - board.getTileSize()/2);
            board.getSelectedPiece().setyPos(e.getY() - board.getTileSize()/2);

            board.repaint();
        }
    }

}
