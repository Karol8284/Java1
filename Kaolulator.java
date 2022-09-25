package impelemtacjek;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Kaolulator {

    static int res = 0, a = 0;
    static String modifier = "";
    static JFrame f = new JFrame("Kalkulator");
    public static void main(String[] args) {
        f.setSize(300, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(2);
        f.setResizable(false);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setBounds(0, 0, 300, 100);
        area.setText("Result...");
        f.add(area);

        List<String> vals = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/", "^");
        int x = 0, y = 100;
        for(String s : vals) {
            JButton b = new JButton(s);
            b.setBounds(x, y, 100, 50);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(s);
                    if(modifier.length()==0) {
                        if(!isNumber(s)) {
                            modifier = s;
                        } else {
                            a = Integer.parseInt(s);
                        }
                    } else {
                        if(isNumber(s)) {
                            int b = Integer.parseInt(s);

                            switch(modifier) {
                                case "+": {
                                    res = a+b;
                                    break;
                                }
                                case "-": {
                                    res = a-b;
                                    break;
                                }
                                case "*": {
                                    res = a*b;
                                    break;
                                }
                                case "/": {
                                    res = a/b;
                                    break;
                                }
                                case "^": {
                                    res = (int) Math.pow(a, b);
                                    break;
                                }
                            }

                            a = 0;
                            area.setText(res+"");
                        } else {
                            modifier = s;
//                            8
                        }
                    }
                }
                private boolean isNumber(String s) {
                    try {
                        Integer.parseInt(s);
                        return true;
                    }catch(Exception e) { return false;}
                }
            });
            f.add(b);
            x+=100;
            if(x==300) {
                x = 0;
                y+=50;
            }
        }

        f.setVisible(true); // f.show();
    }
}
