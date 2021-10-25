package foreEnd.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class SudokuCell extends JButton {
    public int x, y;

    public SudokuCell() {
        setSize(50, 50);
        Font font = new Font("", 2, 24);
        setFont(font);
        setBackground(Color.black);
        setForeground(Color.white);
    }
}
