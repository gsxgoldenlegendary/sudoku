package backEnd.function;

import java.awt.Color;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class Put {
    public static void put(String s) {
        int x, y, value = 0;
        x = s.charAt(4) - '0';
        y = s.charAt(6) - '0';
        try {
            if (s.charAt(3) != ' ' || s.charAt(4) < '0' || s.charAt(4) > '9')
                Framework.textArea.append("Error1:syntax error\n");
            else if (s.charAt(5) >= '0' && s.charAt(5) <= '9')
                Framework.textArea.append("Error3:illegal location\n");
            else if (s.charAt(5) != ' ' || s.charAt(6) < '0' || s.charAt(6) > '9')
                Framework.textArea.append("Error1:syntax error\n");
            else if (s.charAt(7) >= '0' && s.charAt(7) <= '9')
                Framework.textArea.append("Error3:illegal location\n");
            else if (IsOK.isOK(x, y, value = Integer.parseInt(s.substring(8)))) {
                Data.cells[x][y] = value;
                Framework.gamefield.cellbuttons[x][y].setText("" + value);
                Framework.gamefield.cellbuttons[x][y].setBackground(Color.orange);
            }
        } catch (NumberFormatException e) {
            Framework.textArea.append("Error1:syntax error\n");
        }
    }
}
