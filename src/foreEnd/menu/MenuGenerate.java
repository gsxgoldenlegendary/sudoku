package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import backEnd.function.Generate;
import foreEnd.frame.Framework;

public class MenuGenerate extends JMenuItem implements ActionListener {
    public MenuGenerate() {
        setText("Generate");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuGenerate) {
            Framework.textArea.append("Your command:generate\n");
            Generate.generate();
        }
    }
}