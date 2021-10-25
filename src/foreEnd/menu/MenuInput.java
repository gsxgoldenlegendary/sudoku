package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import foreEnd.frame.Framework;

public class MenuInput extends JMenuItem implements ActionListener {
    public MenuInput() {
        setText("Input");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuInput) {
            Framework.textArea.append(
                    "Your command:input\nPlease input your sudoku formally in input textfield\nFormat:\"input a b...\",a,b...are numbers spilted by ONE vacancy\nWaiting for command");
        }
    }
}
