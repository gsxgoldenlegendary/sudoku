package backEnd.function;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class FindAll {
    static int num;
    static boolean[][] isPut;

    public static class SuperThread extends Thread {
        int[][] tempArr;
        int m, n;

        public SuperThread(int x, int y, int[][] upper) {
            m = x;
            n = y;
            tempArr = new int[9][9];
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    tempArr[i][j] = upper[i][j];
        }

        @Override
        public void run() {
            int temp = 0;
            if (9 == m && 0 == n) {
                num++;
                String str = new String();
                str += "The" + num + "solution\n";
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++)
                        str += tempArr[i][j] + " ";
                    str += "\n";
                }
                Framework.textArea.append(str);
            } else if (0 <= m && m < 9 && 0 <= n && n < 9) {
                if (!isPut[m][n]) {
                    for (temp = tempArr[m][n] + 1; temp <= 9; temp++) {
                        if (isOK(m, n, temp, tempArr)) {
                            tempArr[m][n] = temp;
                            if (8 == n)
                                new SuperThread(m + 1, 0, tempArr).start();
                            else
                                new SuperThread(m, n + 1, tempArr).start();
                        }
                    }
                } else {
                    for (; m < 9 && isPut[m][n];)
                        if (8 == n) {
                            m++;
                            n = 0;
                        } else
                            n++;
                    new SuperThread(m, n, tempArr).start();
                }
            }
        }
    }

    public static void findall() {
        num = 0;
        isPut = new boolean[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (Data.cells[i][j] != 0)
                    isPut[i][j] = true;
        new SuperThread(0, 0, Data.cells).start();
    }

    public static boolean isOK(int x, int y, int value, int[][] sodu) {
        if (0 == value)
            return true;
        else {
            for (int i = 0; i < 9; i++) {
                if (i != x && value == sodu[i][y])
                    return false;
                if (i != y && value == sodu[x][i])
                    return false;
            }
            for (int i = x - x % 3; i <= x + 2 - x % 3; i++)
                for (int j = y - y % 3; j <= y + 2 - y % 3; j++)
                    if (!(i == x && j == y) && value == sodu[i][j])
                        return false;
            if (x == y)
                for (int i = 0; i < 9; i++)
                    if (i != x && value == sodu[i][i])
                        return false;
            if (x + y == 8)
                for (int i = 0; i < 9; i++)
                    if (i != x && value == sodu[i][8 - i])
                        return false;
            return true;
        }
    }
}