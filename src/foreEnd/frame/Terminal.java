package foreEnd.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import backEnd.function.FindAll;
import backEnd.function.Generate;
import backEnd.function.Hint;
import backEnd.function.Input;
import backEnd.function.Print;
import backEnd.function.Put;
import backEnd.function.Save;
import backEnd.function.Show;
import backEnd.function.Solve;
import foreEnd.menu.MenuUsage;

public class Terminal extends JPanel implements ActionListener {
    Terminal() {
        setBorder(new TitledBorder("Terminal"));
        setLayout(new BorderLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.textField) {
            String s = Framework.textField.getText();
            Framework.textArea.append("Your command:" + s + "\n");
            Framework.textField.setText("");
            if (s.equals("exit"))
                new MyThread().start();
            else if (s.equals("print"))
                Print.print();
            else if (s.length() >= 167 && s.substring(0, 5).equals("input"))
                Input.input(s);
            else if (s.length() >= 9 && s.substring(0, 3).equals("put"))
                Put.put(s);
            else if (s.equals("generate"))
                Generate.generate();
            else if (s.equals("A*"))
                Solve.a_star_solve();
            else if (s.equals("BT"))
                Solve.bt_solve();
            else if (s.equals("DFS"))
                Solve.dfs_solve();
            else if (s.equals("IDDFS"))
                Solve.iddfs_solve();
            else if (s.equals("findall"))
                FindAll.findall();
            else if (s.length() >= 5 && s.charAt(4) == ' ' && s.substring(0, 4).equals("save"))
                Save.save(s.substring(5));
            else if (s.equals("hint"))
                Hint.hint();
            else if (s.equals("show"))
                Show.show();
            else if (s.equals("usage"))
                MenuUsage.showUsage();
            else if (s.length() >= 6 && s.substring(0, 4).equals("show"))
                Show.show(s);
            else
                Framework.textArea.append("Error1:syntax error\n");
            Framework.textArea.append("Wait for command\n");
        }
    }
}