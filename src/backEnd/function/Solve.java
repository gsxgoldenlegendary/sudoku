package backEnd.function;

import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import backEnd.data.Data;
import foreEnd.frame.Framework;
import javafx.util.Pair;

public class Solve {
    static int[][] sodu;
    static boolean[][][] possibility = new boolean[9][9][9];
    static int[][] hash2 = new int[82][2];
    static Vector<Set<Integer>> CandidaList;
    public static Vector<Pair<Integer, Integer>> Coord;

    public static void dfs_solve() {
        sodu = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                sodu[i][j] = Data.cells[i][j];
        if (dfs_sudoku(0, 0) == true) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    Data.cells[i][j] = sodu[i][j];
            Print.print();
        } else
            Framework.textArea.append("Error6:no answer\n");
    }

    public static void a_star_solve() {
        sodu = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                sodu[i][j] = Data.cells[i][j];
        if (a_star_sudoku() == true) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    Data.cells[i][j] = sodu[i][j];
            Print.print();
        } else
            Framework.textArea.append("Error6:no answer\n");
    }

    public static void bt_solve() {
        sodu = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                sodu[i][j] = Data.cells[i][j];
        if (bt_sudoku() == true) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    Data.cells[i][j] = sodu[i][j];
            Print.print();
        } else
            Framework.textArea.append("Error6:no answer\n");
    }

    public static void iddfs_solve() {
        sodu = new int[9][9];
        EnterAndInitial();
        if (true == solve()) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    Data.cells[i][j] = sodu[i][j];
            Print.print();
        } else
            Framework.textArea.append("Error6:no answer\n");

    }

    static Pair<Integer, Integer> make_pair(int i, int j) {
        return new Pair<Integer, Integer>(i, j);
    }

    public static void Locat_Zero() {
        Coord = new Vector<Pair<Integer, Integer>>();
        Coord.clear();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (sodu[i][j] == 0)
                    Coord.add(make_pair(i, j));
    }

    static void Compute_Cadida(int Count) {
        CandidaList = new Vector<Set<Integer>>();
        CandidaList.clear();
        for (int i = 0; i < Count; i++) {
            Set<Integer> Num = new TreeSet<Integer>();
            for (int j = 0; j < 9; j++)
                Num.add(j + 1);
            int x = Coord.elementAt(i).getKey();
            int y = Coord.elementAt(i).getValue();
            int x0 = x / 3, y0 = y / 3;
            for (int j = 0; j < 9; ++j)
                if (Num.contains(sodu[x][j]))
                    Num.remove(sodu[x][j]);
            for (int k = 0; k < 9; ++k)
                if (Num.contains(sodu[k][y]))
                    Num.remove(sodu[k][y]);
            for (int m = 0; m < 3; ++m)
                for (int n = 0; n < 3; ++n)
                    if (Num.contains(sodu[x0 * 3 + m][y0 * 3 + n]))
                        Num.remove(sodu[x0 * 3 + m][y0 * 3 + n]);
            if (x == y)
                for (int m = 0; m < 9; m++)
                    if (Num.contains(sodu[m][m]))
                        Num.remove(sodu[m][m]);
            if (x + y == 8)
                for (int m = 0; m < 9; m++)
                    if (Num.contains(sodu[m][8 - m]))
                        Num.remove(sodu[m][8 - m]);
            CandidaList.add(Num);
        }
    }

    static Pair<Integer, Integer> Find_Min(int Count) {
        int min = 10, min_index = -1;
        for (int i = 0; i < Count; ++i) {
            int temp = CandidaList.elementAt(i).size();
            if (temp < min) {
                min = temp;
                min_index = i;
            }
        }
        return make_pair(min, min_index);
    }

    public static boolean a_star_sudoku() {
        Locat_Zero();
        int TotalCount = 0, Count = Coord.size();
        Vector<Set<Integer>> popCandidateList = new Vector<Set<Integer>>();
        Vector<Pair<Integer, Integer>> popCoordList = new Vector<Pair<Integer, Integer>>();
        if (Count == 0)
            return true;
        while (Count > 0) {
            Compute_Cadida(Count);
            Pair<Integer, Integer> temp = Find_Min(Count);
            int Min = temp.getKey();
            int MinIndex = temp.getValue();
            if (Min == 0) {
                while (!popCandidateList.lastElement().isEmpty()) {
                    int x = popCoordList.lastElement().getKey();
                    int y = popCoordList.lastElement().getValue();
                    sodu[x][y] = 0;
                    ++Count;
                    Coord.add(popCoordList.lastElement());
                    popCoordList.remove(popCoordList.size() - 1);
                    popCandidateList.remove(popCandidateList.size() - 1);
                }
                int x = popCoordList.lastElement().getKey();
                int y = popCoordList.lastElement().getValue();
                sodu[x][y] = popCandidateList.lastElement().iterator().next();
                popCandidateList.lastElement().remove(sodu[x][y]);
                ++TotalCount;
            } else {
                int x = Coord.elementAt(MinIndex).getKey();
                int y = Coord.elementAt(MinIndex).getValue();
                sodu[x][y] = CandidaList.elementAt(MinIndex).iterator().next();
                CandidaList.elementAt(MinIndex).remove(CandidaList.elementAt(MinIndex).iterator().next());
                popCandidateList.add(CandidaList.elementAt(MinIndex));
                CandidaList.removeElementAt(MinIndex);
                popCoordList.add(Coord.elementAt(MinIndex));
                Coord.removeElementAt(MinIndex);
                --Count;
                ++TotalCount;
            }
        }
        if (TotalCount != 0)
            return true;
        else
            return false;
    }

    public static boolean bt_sudoku() {
        int m = 0, n = 0, temp = 0;
        for (;;) {
            if (9 == m && 0 == n)
                return true;
            else if (-1 == m && 8 == n)
                return false;
            else {
                if (!Data.isPut[m][n]) {
                    for (temp = sodu[m][n] + 1; temp <= 9; temp++) {
                        if (isOK(m, n, temp)) {
                            sodu[m][n] = temp;
                            break;
                        }
                    }
                    if (temp > 9) {
                        sodu[m][n] = 0;
                        do {
                            if (0 == n) {
                                m--;
                                n = 8;
                            } else
                                n--;
                        } while (Data.isPut[m][n] && m >= 0);
                        continue;
                    } else {
                        if (8 == n) {
                            m++;
                            n = 0;
                        } else
                            n++;
                        continue;
                    }
                } else {
                    if (8 == n) {
                        m++;
                        n = 0;
                    } else
                        n++;
                    continue;
                }
            }
        }
    }

    static int sudofind(int m, int n, int[] b) {
        int[] c = new int[10];
        for (int i = 0; i < 9; i++) {
            c[sodu[i][n]]++;
            c[sodu[m][i]]++;
        }
        for (int i = m - m % 3; i <= m + 2 - m % 3; i++)
            for (int j = n - n % 3; j <= n + 2 - n % 3; j++)
                c[sodu[i][j]]++;
        int k = 0;
        for (int i = 1; i < 10; i++)
            if (0 == c[i]) {
                b[k] = i;
                k++;
            }
        return k;
    }

    public static boolean dfs_sudoku(int m, int n) {
        if (8 == m && 8 == n) {
            if (0 != sodu[m][n])
                return true;
            else {
                int[] b = new int[9];
                sudofind(m, n, b);
                if (0 != b[0]) {
                    sodu[m][n] = b[0];
                    return true;
                } else
                    return false;
            }
        } else if (0 == sodu[m][n]) {
            int[] b = new int[9];
            int end = sudofind(m, n, b);
            if (0 == b[0])
                return false;
            else {
                for (int k = 0; k < end; k++) {
                    sodu[m][n] = b[k];
                    if (8 != n) {
                        if (true == dfs_sudoku(m, n + 1))
                            return true;
                    } else if (8 != m)
                        if (true == dfs_sudoku(m + 1, 0))
                            return true;
                    sodu[m][n] = 0;
                }
                return false;
            }
        } else if (8 != n) {
            if (true == dfs_sudoku(m, n + 1))
                return true;
        } else if (8 != m)
            if (true == dfs_sudoku(m + 1, 0))
                return true;
        return false;
    }

    static void EnterAndInitial() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                sodu[i][j] = Data.cells[i][j];
                if (sodu[i][j] != 0) {
                    for (int cnt3 = 0; cnt3 < 9; cnt3++)
                        possibility[i][j][cnt3] = false;
                    possibility[i][j][sodu[i][j] - 1] = true;
                } else
                    for (int cnt3 = 0; cnt3 < 9; cnt3++)
                        possibility[i][j][cnt3] = true;
            }
    }

    static void GetUniquity() {
        int temp1, temp2 = 0, temp3 = 0, x, y;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                temp1 = 0;
                for (int cnt3 = 0; cnt3 < 9; cnt3++)
                    if (possibility[i][cnt3][j]) {
                        temp1++;
                        temp2 = cnt3;
                    }
                if (temp1 == 1) {
                    sodu[i][temp2] = j + 1;
                    for (int cnt3 = 0; cnt3 < 9; cnt3++)
                        possibility[i][temp2][cnt3] = false;
                    possibility[i][temp2][j] = true;
                }
            }
        for (int cnt1 = 0; cnt1 < 9; cnt1++)
            for (int cnt2 = 0; cnt2 < 9; cnt2++) {
                temp1 = 0;
                for (int cnt3 = 0; cnt3 < 9; cnt3++)
                    if (possibility[cnt3][cnt1][cnt2]) {
                        temp1++;
                        temp2 = cnt3;
                    }
                if (temp1 == 1) {
                    sodu[temp2][cnt1] = cnt2 + 1;
                    for (int cnt3 = 0; cnt3 < 9; cnt3++)
                        possibility[temp2][cnt1][cnt3] = false;
                    possibility[temp2][cnt1][cnt2] = true;
                }
            }
        for (x = 0; x < 9; x += 3)
            for (y = 0; y < 9; y += 3) {
                for (int cnt1 = 0; cnt1 < 9; cnt1++) {
                    temp1 = 0;
                    for (int cnt2 = 0; cnt2 < 3; cnt2++)
                        for (int cnt3 = 0; cnt3 < 3; cnt3++)
                            if (possibility[cnt2 + y][cnt3 + x][cnt1]) {
                                temp1++;
                                temp2 = cnt2;
                                temp3 = cnt3;
                            }
                    if (temp1 == 1) {
                        sodu[temp2 + y][temp3 + x] = cnt1 + 1;
                        for (int cnt3 = 0; cnt3 < 9; cnt3++)
                            possibility[temp2 + y][temp3 + x][cnt3] = false;
                        possibility[temp2 + y][temp3 + x][cnt1] = true;
                    }
                }
            }
    }

    static void DiminishPossibility() {
        int x, y;
        for (int cnt1 = 0; cnt1 < 9; cnt1++)
            for (int cnt2 = 0; cnt2 < 9; cnt2++) {
                if (sodu[cnt1][cnt2] != 0) {
                    if (cnt1 < 3)
                        y = 0;
                    else if (cnt1 < 6)
                        y = 3;
                    else
                        y = 6;
                    if (cnt2 < 3)
                        x = 0;
                    else if (cnt2 < 6)
                        x = 3;
                    else
                        x = 6;
                    for (int cnt3 = 0; cnt3 < 9; cnt3++) {
                        possibility[cnt1][cnt3][sodu[cnt1][cnt2] - 1] = false;
                        possibility[cnt3][cnt2][sodu[cnt1][cnt2] - 1] = false;
                    }
                    for (int cnt3 = 0; cnt3 < 3; cnt3++)
                        for (int cnt4 = 0; cnt4 < 3; cnt4++)
                            possibility[cnt3 + y][cnt4 + x][sodu[cnt1][cnt2] - 1] = false;
                }
            }
    }

    static int NextState() {
        int amountOfPossibility;
        int temp1 = 0;
        int rest = 81;
        for (int cnt1 = 0; cnt1 < 9; cnt1++)
            for (int cnt2 = 0; cnt2 < 9; cnt2++) {
                amountOfPossibility = 0;
                for (int cnt3 = 0; cnt3 < 9; cnt3++) {
                    if (possibility[cnt1][cnt2][cnt3]) {
                        amountOfPossibility++;
                        temp1 = cnt3 + 1;
                    }
                }
                if (amountOfPossibility == 1)
                    sodu[cnt1][cnt2] = temp1;
                if (sodu[cnt1][cnt2] != 0)
                    rest--;
            }
        return rest;
    }

    static boolean IsCalculatable() {
        int ptr = 0;
        int rest = 81, lastStepRest = 81;
        while (rest > 0) {
            GetUniquity();
            DiminishPossibility();
            rest = NextState();
            if (lastStepRest != rest)
                lastStepRest = rest;
            else {
                for (int cnt1 = 0; cnt1 < 9; cnt1++)
                    for (int cnt2 = 0; cnt2 < 9; cnt2++)
                        if (sodu[cnt1][cnt2] == 0) {
                            hash2[ptr][0] = cnt1;
                            hash2[ptr++][1] = cnt2;
                        }
                hash2[ptr][0] = -1;
                hash2[ptr][1] = -1;
                return false;
            }
        }
        return true;
    }

    static boolean IsRational() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (!isOK(i, j, sodu[i][j]))
                    return false;
        return true;
    }

    public static boolean isOK(int x, int y, int value) {
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

    static boolean DFS(int depth) {
        if (hash2[depth][0] == -1)
            return true;
        else {
            for (int cnt1 = 1; cnt1 <= 9; cnt1++) {
                if (possibility[hash2[depth][0]][hash2[depth][1]][cnt1 - 1]) {
                    sodu[hash2[depth][0]][hash2[depth][1]] = cnt1;
                    if (IsRational() && DFS(depth + 1))
                        return true;
                    else
                        sodu[hash2[depth][0]][hash2[depth][1]] = 0;
                }
            }
            return false;
        }
    }

    static boolean solve() {
        if (IsRational())
            if (IsCalculatable() || DFS(0))
                return true;
            else
                return false;
        else
            return false;
    }

}