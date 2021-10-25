package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Solve;
import foreEnd.frame.Framework;

public class MenuSolve extends JMenuItem implements ActionListener {
    public MenuSolve() {
        setText("Solve(BT)");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuSolve1) {
            Framework.textArea.append("Your command:solve(BT)\n");
            Solve.bt_solve();
        }
    }
}
