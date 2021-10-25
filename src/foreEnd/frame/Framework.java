package foreEnd.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import foreEnd.menu.MenuExit;
import foreEnd.menu.MenuFindAll;
import foreEnd.menu.MenuGenerate;
import foreEnd.menu.MenuHint;
import foreEnd.menu.MenuInput;
import foreEnd.menu.MenuPrint;
import foreEnd.menu.MenuSave;
import foreEnd.menu.MenuShow;
import foreEnd.menu.MenuSolve;
import foreEnd.menu.MenuSolve2;
import foreEnd.menu.MenuSolve3;
import foreEnd.menu.MenuSolve4;
import foreEnd.menu.MenuUsage;

public class Framework extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu function = new JMenu("Function");
    public static MenuExit menuExit = new MenuExit();
    public static MenuPrint menuPrint = new MenuPrint();
    public static MenuInput menuInput = new MenuInput();
    public static MenuGenerate menuGenerate = new MenuGenerate();
    public static MenuSolve menuSolve1 = new MenuSolve();
    public static MenuSolve2 menuSolve2 = new MenuSolve2();
    public static MenuSolve3 menuSolve3 = new MenuSolve3();
    public static MenuSolve4 menuSolve4 = new MenuSolve4();
    public static MenuFindAll menuFindAll = new MenuFindAll();
    public static MenuSave menuSave = new MenuSave();
    public static MenuHint menuHint = new MenuHint();
    public static MenuShow menuShow = new MenuShow();
    public static MenuUsage menuUsage = new MenuUsage();
    public static GameField gamefield = new GameField();
    public static SuperTextArea textArea = new SuperTextArea(14, 30);
    static JTextField textField = new JTextField(30);
    Container c = getContentPane();
    static int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    static int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    public static JScrollPane scrollPane = new JScrollPane(textArea, v, h);
    public Terminal terminal = new Terminal();
    public Timer userTimeAction;

    public Framework() {
        super("Sudoku");
        textArea.setEditable(false);
        MenuUsage.showUsage();
        textField.addActionListener(terminal);
        setLayout(new BorderLayout());
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(function);
        file.add(menuUsage);
        file.add(menuSave);
        file.add(menuShow);
        file.add(menuExit);
        function.add(menuPrint);
        function.add(menuInput);
        function.add(menuGenerate);
        function.add(menuSolve1);
        function.add(menuSolve2);
        function.add(menuSolve3);
        function.add(menuSolve4);
        function.add(menuFindAll);
        function.add(menuHint);
        c.add("Center", gamefield);
        c.add("South", terminal);
        terminal.add("North", scrollPane);
        terminal.add("Center", new JLabel("Input"));
        terminal.add("South", textField);
        setSize(550, 900);
        setLocation(400, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
