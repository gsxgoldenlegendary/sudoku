package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Solve;
import foreEnd.frame.Framework;

public class MenuSolve4 extends JMenuItem implements ActionListener {
    public MenuSolve4() {
        setText("Solve(A*)");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuSolve4) {
            Framework.textArea.append("Your command:solve(A*)\n");
            Solve.a_star_solve();
        }
    }
}
