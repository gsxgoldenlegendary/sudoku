package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.FindAll;
import foreEnd.frame.Framework;

public class MenuFindAll extends JMenuItem implements ActionListener {
    public MenuFindAll() {
        setText("FindAll");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuFindAll) {
            Framework.textArea.append("Your command:findall\n");
            FindAll.findall();
        }
    }
}
