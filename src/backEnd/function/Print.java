package backEnd.function;

import java.awt.Color;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class Print {
    public static void print() {
        Framework.textArea.append("Current sudoku state is:\n");
        /*
         * for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++)
         * Framework.gamefield.cellbuttons[i][j].setBackground(Color.black);
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Framework.textArea.append(" " + Data.cells[i][j]);
                if (0 != Data.cells[i][j]) {
                    Framework.gamefield.cellbuttons[i][j].setText("" + Data.cells[i][j]);
                    if (Data.isPut[i][j]) {
                        Framework.gamefield.cellbuttons[i][j].setBackground(Color.blue);
                        Framework.gamefield.cellbuttons[i][j].setEnabled(false);
                        Framework.gamefield.cellbuttons[i][j].removeMouseListener(Framework.gamefield);
                    } else {
                        if (Color.green != Framework.gamefield.cellbuttons[i][j].getBackground())
                            Framework.gamefield.cellbuttons[i][j].setBackground(Color.orange);
                        Framework.gamefield.cellbuttons[i][j].setEnabled(true);
                    }
                } else {
                    if (!Framework.gamefield.cellbuttons[i][j].isEnabled())
                        Framework.gamefield.cellbuttons[i][j].addMouseListener(Framework.gamefield);
                    Framework.gamefield.cellbuttons[i][j].setText("");
                    Framework.gamefield.cellbuttons[i][j].setEnabled(true);
                    Framework.gamefield.cellbuttons[i][j].setBackground(Color.black);
                }
            }
            Framework.textArea.append("\n");
        }
        Framework.textArea.append("Wait for command:\n");
    }
}
