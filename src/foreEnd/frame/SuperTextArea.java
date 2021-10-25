package foreEnd.frame;

import java.awt.Font;

import javax.swing.JTextArea;

public class SuperTextArea extends JTextArea {
    public SuperTextArea(int m, int n) {
        super(m, n);
        setFont(new Font("Arial", Font.BOLD, 14));
    }

    public void append(String str) {
        super.append(str);
        this.setCaretPosition(this.getText().length());
    }
}
