import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {

    private int col, row, xPos, yPos;
    private boolean isRed;
    private Board board;

    BufferedImage sheet;
    {
        try{
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int sheetScale = sheet.getWidth()/2;

    Image sprite;


    Piece(Board board, int row, int col, boolean isRed){
        this.board = board;
        this.col = col;
        this.row = row;
        this.isRed = isRed;

        int x,y;
        if (isRed){
            x = sheetScale;
            y = 0;
        } else{
            x = 0;
            y = sheetScale;
        }
        this.sprite = sheet.getSubimage(x, y, sheetScale, sheetScale).getScaledInstance(board.getTileSize(), board.getTileSize(), BufferedImage.SCALE_SMOOTH);
        this.xPos = col * board.getTileSize();
        this.yPos = row * board.getTileSize();
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public BufferedImage getSheet() {
        return sheet;
    }

    public void setSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public int getSheetScale() {
        return sheetScale;
    }

    public void setSheetScale(int sheetScale) {
        this.sheetScale = sheetScale;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public void paint(Graphics2D g2d){
        g2d.drawImage(sprite, xPos, yPos, null);
    }
}
