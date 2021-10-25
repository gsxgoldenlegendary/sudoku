package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Print;
import foreEnd.frame.Framework;

public class MenuPrint extends JMenuItem implements ActionListener {
    public MenuPrint() {
        setText("Print");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuPrint) {
            Framework.textArea.append("Your command:print\n");
            Print.print();
        }
    }
}
