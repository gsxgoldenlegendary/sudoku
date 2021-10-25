package foreEnd.frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import backEnd.data.Data;
import backEnd.function.IsOK;

public class GameField extends JPanel implements MouseListener {
    public SudokuCell[][] cellbuttons;
    private SelectNumFrame selectNum;

    GameField() {
        setBorder(new TitledBorder("GameField"));
        setLayout(null);
        cellbuttons = new SudokuCell[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                cellbuttons[i][j] = new SudokuCell();
                cellbuttons[i][j].setLocation(20 + j * 50 + (j / 3) * 5, 20 + i * 50 + (i / 3) * 5);
                cellbuttons[i][j].x = i;
                cellbuttons[i][j].y = j;
                if (0 != Data.cells[i][j]) {
                    cellbuttons[i][j].setText("" + Data.cells[i][j]);
                    cellbuttons[i][j].setEnabled(false);
                    cellbuttons[i][j].setForeground(Color.black);
                } else
                    cellbuttons[i][j].addMouseListener(this);
                add(cellbuttons[i][j]);
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int i = ((SudokuCell) e.getSource()).x;
        int j = ((SudokuCell) e.getSource()).y;
        int value;
        if (selectNum != null) {
            selectNum.dispose();
        }
        selectNum = new SelectNumFrame();
        selectNum.setModal(true);
        selectNum.setLocation(e.getLocationOnScreen().x, e.getLocationOnScreen().y);
        selectNum.setCell((SudokuCell) e.getSource());
        selectNum.setVisible(true);
        value = Integer.parseInt(((SudokuCell) e.getSource()).getText());
        if (IsOK.isOK(i, j, value)) {
            Data.cells[i][j] = value;
            Framework.textArea.append("Your command:put " + i + " " + j + " " + value + "\nWait command\n");
        } else {
            cellbuttons[i][j].setText("");
            Data.cells[i][j] = 0;
            cellbuttons[i][j].setBackground(Color.black);
            Framework.textArea.append("Your command:put " + i + " " + j + " " + value + "\nWait command\n");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
