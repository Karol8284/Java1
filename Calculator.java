import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame f;
    JTextField t;
    JButton[] nb = new JButton[10];
    JButton[] fb =new JButton[9];
    JButton addB,subB,mulB,divB,decB,equB,delB,clrB,negB;
    JPanel p;
    double num1=0,num2=0,res=0;
    String tbnVal[] = {"+","-","*","/",".","=","Delate","Clear"};
    char operator;

    Calculator(){

        f = new JFrame("Calculator");
        f.setDefaultCloseOperation(2);
        f.setSize(420,550);
        f.setLayout(null);

        t = new JTextField();
        t.setBounds(50,25,300,50);
        t.setEditable(false);

        addB = new JButton("+");
        subB = new JButton("-");
        mulB = new JButton("*");
        divB = new JButton("/");
        decB = new JButton(".");
        equB = new JButton("=");
        delB = new JButton("Delate");
        clrB = new JButton("Clear");
        negB = new JButton("(-)");

        fb[0] =addB;
        fb[1] =subB;
        fb[2] =mulB;
        fb[3] =divB;
        fb[4] =decB;
        fb[5] =equB;
        fb[6] =delB;
        fb[7] =clrB;
        fb[8] =negB;

        for (int i=0;i< fb.length;i++){
            fb[i].addActionListener(this);
            fb[i].setFocusable(false);
        }

        for (int i=0;i< nb.length;i++){
            nb[i] = new JButton(String.valueOf(i));
            nb[i].addActionListener(this);
            nb[i].setFocusable(false);
        }

        negB.setBounds(50,430,100,50);
        delB.setBounds(150,430,100,50);
        clrB.setBounds(250,430,100,50);

        p = new JPanel();
        p.setBounds(50,100,300,300);
        p.setLayout(new GridLayout(4,4,10,10));
        p.setBackground(new Color(26, 32, 58));

        p.add(nb[1]);
        p.add(nb[2]);
        p.add(nb[3]);
        p.add(addB);
        p.add(nb[4]);
        p.add(nb[5]);
        p.add(nb[6]);
        p.add(subB);
        p.add(nb[7]);
        p.add(nb[8]);
        p.add(nb[9]);
        p.add(mulB);
        p.add(decB);
        p.add(nb[0]);
        p.add(equB);
        p.add(divB);
        p.add(negB);

        f.add(p);
        f.add(negB);
        f.add(delB);
        f.add(clrB);
        f.add(t);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i< nb.length;i++){
            if (e.getSource() == nb[i]){
                t.setText(t.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decB){
            t.setText(t.getText().concat(String.valueOf(".")));
        }
        if (e.getSource() == addB){
            num1 = Double.parseDouble(t.getText());
            operator = '+';
            t.setText("");
        }
        if (e.getSource() == subB){
            num1 = Double.parseDouble(t.getText());
            operator = '-';
            t.setText("");
        }
        if (e.getSource() == mulB){
            num1 = Double.parseDouble(t.getText());
            operator = '*';
            t.setText("");
        }
        if (e.getSource() == divB){
            num1 = Double.parseDouble(t.getText());
            operator = '/';
            t.setText("");
        }
        if (e.getSource() == equB){
            num2 = Double.parseDouble(t.getText());
            switch (operator) {
                case '+' -> res = num1 + num2;
                case '-' -> res = num1 - num2;
                case '*' -> res = num1 * num2;
                case '/' -> res = num1 / num2;
            }
            t.setText(String.valueOf(res));
        }
        if (e.getSource()==clrB){
            t.setText("");
        }
        if (e.getSource()==delB){
            String string = t.getText();
            t.setText("");
            for (int i=0;i<string.length()-1;i++){
                t.setText(t.getText()+string.charAt(i));
            }
        }
        if (e.getSource()==negB){
            System.out.println(e+ "dwadad");
            double temp = Double.parseDouble(t.getText());
            temp*=-1;
            t.setText(String.valueOf(temp));
        }
    }
}
