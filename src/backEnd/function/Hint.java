package backEnd.function;

import java.awt.Color;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class Hint {

    public static void hint() {
        int m = 0, n = 0;
        Solve.sodu = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                Solve.sodu[i][j] = Data.cells[i][j];
        A: for (m = 0; m < 9; m++)
            for (n = 0; n < 9; n++)
                if (0 == Data.cells[m][n])
                    break A;
        if (true == Solve.dfs_sudoku(m, n)) {
            Framework.gamefield.cellbuttons[m][n].setText("" + Solve.sodu[m][n]);
            Framework.gamefield.cellbuttons[m][n].setBackground(Color.green);
            Data.cells[m][n] = Solve.sodu[m][n];
            Print.print();
        } else
            Framework.textArea.append("Error6:No Answer\n");
    }
}
