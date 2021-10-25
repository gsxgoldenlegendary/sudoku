package backEnd.function;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import backEnd.data.Data;
import foreEnd.frame.Framework;

public class Show {
    static FileReader in;
    static FileReader in2;
    static BufferedReader reader;
    static BufferedReader reader2;
    String[] cache;

    public static void show() {
        int line = 0;
        String str;
        try {
            in = new FileReader(
                    "C:\\Users\\GoldenLengendWindows\\Desktop\\Important Files\\VSCodeJava\\Sudoku\\src\\backEnd\\data\\cache.txt");
            reader = new BufferedReader(in);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while ((str = reader.readLine()) != null) {
                if (str.length() > 0) {
                    if (0 == line % 2)
                        Framework.textArea.append(line / 2 + "-" + str);
                    else
                        Framework.textArea.append(" " + str + "\n");
                    line++;
                }
            }
            Framework.textArea
                    .append("Input the record code to load game\nFormat:\"show num\",num is a number showed\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void show(String s) {
        int line = 0, l = 0;
        try {
            l = Integer.parseInt(s.substring(5));
        } catch (NumberFormatException e) {
            Framework.textArea.append("Error1:syntax error\n");
        }
        String str = new String();
        try {
            in = new FileReader(
                    "C:\\Users\\GoldenLengendWindows\\Desktop\\Important Files\\VSCodeJava\\Sudoku\\src\\backEnd\\data\\cache.txt");
            reader = new BufferedReader(in);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while ((str = reader.readLine()) != null) {
                if (line == 2 * l)
                    break;
                line++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            in2 = new FileReader(
                    "C:\\Users\\GoldenLengendWindows\\Desktop\\Important Files\\VSCodeJava\\Sudoku\\src\\backEnd\\data\\"
                            + str + ".txt");
            reader2 = new BufferedReader(in2);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {
                    Data.cells[i][j] = reader2.read() - '0';
                    reader2.read();
                }
            reader2.read();
            int temp = 0;
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {
                    temp = reader2.read();
                    if ('0' == temp)
                        Data.isPut[i][j] = false;
                    else if ('1' == temp)
                        Data.isPut[i][j] = true;
                    reader2.read();
                }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Framework.textArea.append("Last time suduko is\n");
        Print.print();
    }
}
