package backEnd.function;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class IsOK {
    public static boolean isOK(int x, int y, int value) {
        if (0 >= value || value > 9) {
            Framework.textArea.append("Error2:data range exceed\n");
            return false;
        } else if (x < 0 || x >= 9 || y < 0 || y >= 9) {
            Framework.textArea.append("Error3:illegal location\n");
            return false;
        } else if (true == Data.isPut[x][y]) {
            Framework.textArea.append("Error5:there is already a number in this position\n");
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (i != x && value == Data.cells[i][y]) {
                    Framework.textArea
                            .append("Error4:illegal, the line " + i + " column " + y + " has the same number\n");
                    return false;
                }
                if (i != y && value == Data.cells[x][i]) {
                    Framework.textArea
                            .append("Error4:illegal, the line " + x + " column " + i + " has the same number\n");
                    return false;
                }
            }
            for (int i = x - x % 3; i <= x + 2 - x % 3; i++)
                for (int j = y - y % 3; j <= y + 2 - y % 3; j++)
                    if (!(i == x && j == y) && value == Data.cells[i][j]) {
                        Framework.textArea
                                .append("Error4:illegal, the line " + i + " column " + j + " has the same number\n");
                        return false;
                    }
            if (x == y) {
                for (int i = 0; i < 9; i++)
                    if (i != x && value == Data.cells[i][i]) {
                        Framework.textArea
                                .append("Error4:illegal, the line " + i + " column " + i + " has the same number\n");
                        return false;
                    }
            }
            if (8 == x + y) {
                for (int i = 0; i < 9; i++)
                    if (i != x && value == Data.cells[i][8 - i]) {
                        Framework.textArea.append("Error4:illegal, the line " + i + " column " + (int) (8 - i)
                                + " has the same number\n");
                        return false;
                    }
            }
        }
        return true;
    }
}
