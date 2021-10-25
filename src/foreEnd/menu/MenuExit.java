package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import foreEnd.frame.Framework;
import foreEnd.frame.MyThread;

public class MenuExit extends JMenuItem implements ActionListener {
    public MenuExit() {
        setText("Exit");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuExit) {
            Framework.textArea.append("Your command:exit\n");
            new MyThread().start();
        }
    }
}