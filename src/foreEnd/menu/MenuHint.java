package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Hint;
import foreEnd.frame.Framework;

public class MenuHint extends JMenuItem implements ActionListener {
    public MenuHint() {
        setText("Hint");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuHint) {
            Framework.textArea.append("Your command:hint\n");
            Hint.hint();
        }
    }
}
