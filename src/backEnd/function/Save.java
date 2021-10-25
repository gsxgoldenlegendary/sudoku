package backEnd.function;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class Save {
    public static void save(String s) {
        File f = new File(
                "C:\\Users\\GoldenLengendWindows\\Desktop\\Important Files\\VSCodeJava\\Sudoku\\src\\backEnd\\data\\"
                        + s + ".txt");
        Date d = new Date();
        if (f.exists()) {
            Framework.textArea.append("Error7:file existed\nInput your game record name again\n");
        } else {
            PrintWriter pw1 = null, pw2 = null;
            try {
                pw1 = new PrintWriter(
                        "C:\\Users\\GoldenLengendWindows\\Desktop\\Important Files\\VSCodeJava\\Sudoku\\src\\backEnd\\data\\"
                                + s + ".txt");
                pw2 = new PrintWriter(new BufferedWriter(new FileWriter(
                        "C:\\Users\\GoldenLengendWindows\\Desktop\\Important Files\\VSCodeJava\\Sudoku\\src\\backEnd\\data\\cache.txt",
                        true)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    pw1.print(Data.cells[i][j] + " ");
            pw1.print("\n");
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    if (true == Data.isPut[i][j])
                        pw1.print("1 ");
                    else
                        pw1.print("0 ");
            pw2.println(s + "\n" + d);
            pw1.close();
            pw2.close();
            Framework.textArea.append("Game state recorded successfully\n");
        }
    }
}
