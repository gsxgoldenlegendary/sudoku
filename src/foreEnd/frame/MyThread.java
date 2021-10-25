package foreEnd.frame;

public class MyThread extends Thread {
    public MyThread() {
        setPriority(MAX_PRIORITY);
    }

    @Override
    public void run() {
        Framework.textField.setText("");
        Framework.textArea.append("Program exits in 5 seconds.Bye!\n");
        long begintime = System.currentTimeMillis();
        for (;;) {
            if (5000 < System.currentTimeMillis() - begintime)
                System.exit(0);
        }
    }
}
