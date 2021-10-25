package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Solve;
import foreEnd.frame.Framework;

public class MenuSolve2 extends JMenuItem implements ActionListener {
    public MenuSolve2() {
        setText("Solve(IDDFS)");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuSolve2) {
            Framework.textArea.append("Your command:solve(IDDFS)\n");
            Solve.iddfs_solve();
        }
    }
}
