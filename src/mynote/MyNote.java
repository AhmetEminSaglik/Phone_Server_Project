package mynote;

import javax.swing.*;

public class MyNote {

    static boolean gosterildi = false;

    public static void showMessageDialog(String text) {
        if (!gosterildi) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, text);
                }
            }).start();
        }

        gosterildi = true;
    }

    public static void showinOutPut(Class clazz, String text) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(clazz.getName());
        System.out.println("MY NOTE : " + text);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");

    }
}
