package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import foreEnd.frame.Framework;

public class MenuSave extends JMenuItem implements ActionListener {
    public MenuSave() {
        setText("Save");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuSave) {
            Framework.textArea.append(
                    "Your command:save\nInput your game record name.\nFormat:\"save name\",name is your expected file name.");
        }
    }
}
