package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Show;
import foreEnd.frame.Framework;

public class MenuShow extends JMenuItem implements ActionListener {
    public MenuShow() {
        setText("Show");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuShow) {
            Framework.textArea.append("Your command:show\n");
            Show.show();
        }
    }
}