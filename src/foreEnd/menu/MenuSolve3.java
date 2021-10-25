package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Solve;
import foreEnd.frame.Framework;

public class MenuSolve3 extends JMenuItem implements ActionListener {
    public MenuSolve3() {
        setText("Solve(DFS)");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuSolve3) {
            Framework.textArea.append("Your command:solve(DFS)\n");
            Solve.dfs_solve();
        }
    }
}
