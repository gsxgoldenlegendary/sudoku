package backEnd.function;

import backEnd.data.Data;

public class Generate {
    public static void generate() {
        int temp[][] = { { 5, 8, 1, 4, 2, 7, 6, 9, 3 }, { 3, 7, 4, 5, 9, 6, 8, 1, 2 }, { 9, 6, 2, 1, 3, 8, 4, 7, 5 },
                { 6, 2, 9, 3, 8, 5, 7, 4, 1 }, { 1, 5, 7, 9, 6, 4, 3, 2, 8 }, { 8, 4, 3, 2, 7, 1, 5, 6, 9 },
                { 4, 1, 8, 7, 5, 2, 9, 3, 6 }, { 2, 9, 5, 6, 4, 3, 1, 8, 7 }, { 7, 3, 6, 8, 1, 9, 2, 5, 4 } };
        Data.cells = temp.clone();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                Data.isPut[i][j] = false;
                if (10 * Math.random() > 5) {
                    Data.cells[i][j] = 0;
                    Data.isPut[i][j] = false;
                } else
                    Data.isPut[i][j] = true;
            }
        Print.print();
    }
}
