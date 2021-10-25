package backEnd.function;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class Input {
    public static void input(String s) {
        if (s.length() > 167) {
            Framework.textArea.append("Error1:syntax error\nWait for command\n");
            return;
        } else {
            for (int i = 0, k = 6; i < 9; i++)
                for (int j = 0; j < 9; k++)
                    if (0 == k % 2) {
                        if (IsOK.isOK(i, j, s.charAt(k) - '0')) {
                            Data.cells[i][j] = s.charAt(k) - '0';
                            j++;
                        } else if (0 > s.charAt(k) || s.charAt(k) > 9) {
                            Framework.textArea.append("Error1:syntax error\nWait for command\n");
                            return;
                        }
                    } else if (1 == k % 2 && s.charAt(k) != ' ') {
                        Framework.textArea.append("Error1:syntax error\nWait for command\n");
                        return;
                    }
            Framework.textArea.append("Accept your input.\n");
            Print.print();
        }
    }
}
