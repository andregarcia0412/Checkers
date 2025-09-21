import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(1000,1000));
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        Board board = new Board();
        frame.add(board);

        frame.setVisible(true);
    }
}
