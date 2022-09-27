package dodatkowe;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ToByte
{
    JFrame f;
    JTextArea t,tr;
    JPanel p;
    byte[] b;
    String trv;

    ToByte() {
        f = new JFrame("Tekset na bity");
        f.setDefaultCloseOperation(2);
        f.setSize(600, 700);
        f.setLayout(null);

        tr = new JTextArea();
        tr.setBounds(50,300,500,300);

        t = new JTextArea();
        t.setBounds(50,5,500,200);
        t.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    if(e.getKeyCode()==0) {
                        b = t.getText().getBytes("utf-8");
                        tr.setText("");
                        for (int i=0;i<b.length;i++){
                            tr.setText(tr.getText()+b[i]+" ");
                        }
                    } else {
                        b = (t.getText()+e.getKeyChar()).getBytes("utf-8");
                        for (int i=0;i<b.length;i++){
                            tr.setText(tr.getText()+b[i]);
                        }
                    }
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }
            @Override public void keyPressed(KeyEvent e) {

            }
            @Override public void keyReleased(KeyEvent e) {

            }
        });

        f.add(t);
        f.add(tr);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        ToByte toByte = new ToByte();
    }
}
