package foreEnd.frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;

class SelectNumFrame extends JDialog implements MouseListener {
    private SudokuCell cell;

    public void setCell(SudokuCell cell_2) {
        cell = cell_2;
    }

    public SelectNumFrame() {
        setTitle("Put");
        setSize(160, 185);
        setBackground(Color.blue);
        setLayout(null);
        addNum();
    }

    private void addNum() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                btn.setSize(50, 50);
                btn.setLocation(i * 50, j * 50);
                btn.setText("" + (j * 3 + i + 1));
                btn.addMouseListener(this);
                this.add(btn);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        cell.setText(((JButton) e.getSource()).getText());
        cell.setBackground(Color.orange);
        dispose();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
