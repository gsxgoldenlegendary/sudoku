package foreEnd.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import foreEnd.frame.Framework;

public class MenuUsage extends JMenuItem implements ActionListener {
    static String str = "Welcome to my sudoku world!\n" + "usage:\n"
            + "1.Enter \"exit\" or press \"Exit\" to quit programme in 5 minutes.\n"
            + "2.Enter \"print\" or press \"Print\" to print current sudoku state. 0 filled for vacancy. \n"
            + "3.press \"Input\" to input a soduku. Cement format shown then.\n"
            + "4.Enter or press \"generate\" to generate a sudoku which has 17 non-zero at least numbers at random.\n"
            + "5.Enter \"DFS\" or press \"Solve(DFS)\" to solve surrent sudoku by depth-first search method.\n"
            + "6.Enter \"IDDFS\" or press \"Solve(IDDFS)\" to solve surrent sudoku by iterative deepening depth-first search method.\n"
            + "7.Enter \"A*\" or press \"Solve(A*)\" to solve surrent sudoku by heuristically search method.\n"
            + "8.Enter \"put x y z\" or choose number by mouse to put z into x row y column.Array counted from 0. \n"
            + "9.Enter \"hint\" or press \"Hint\" to get a hint cell.\n"
            + "10.Press \"Save\" to save current sudoku. Operation following shown then.\n"
            + "11.Enter \"show\" or press \"Show\" to view saved game. Operation following shown then.\n"
            + "12.Enter \"usage\" or press \"Usage\" to get usage.\n"
            + "13.Enter \"findall\" or press\"FindAll\" to find all solution(s) by multi-threads method.\n"
            + "14.Enter \"BT\" or press \"Solve(BT)\" to solve surrent sudoku by back tracking method.\n"
            + "Error list:\n" + "Error1:syntax error\n" + "Error2:data range exceed\n" + "Error3:illegal location\n"
            + "Error4:illegal, the line x column y has the same number\n"
            + "Error5:there is already a number in this position\n" + "Error6:No Answer\n" + "Error7:file existed\n"
            + "Have fun!\n" + "Waiting for command:";

    public MenuUsage() {
        setText("Usage");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Framework.menuUsage) {
            Framework.textArea.append("Your command:usage\n");
            showUsage();
        }
    }

    public static void showUsage() {
        Framework.textArea.append(str);
    }
}