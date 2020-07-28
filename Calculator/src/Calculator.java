import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Calculator implements ActionListener
{

    JFrame f;
    JTextField t,t2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bsub,badd,bdec,beq,bclr,bdif,bcos,bsin;

    double a=0;
    double b=0;
    double c = 0;
    int opDone=0;
    int diff = 0;
    double result=0;
    double answer=0;
    int resDone=0;
    int operator=0;

    Calculator()
    {
        f=new JFrame("Calculator");
        t=new JTextField();
        t2=new JTextField();
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        b0=new JButton("0");
        bdiv=new JButton("/");
        bmul=new JButton("*");
        bsub=new JButton("-");
        badd=new JButton("+");
        bdec=new JButton(".");
        beq=new JButton("=");
        bdif=new JButton("+/-");
        bcos=new JButton("cos");
        bsin=new JButton("sin");
        bclr=new JButton("C");

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("About");
        JMenuItem menuItemAbout = new JMenuItem("Calculator by Sergei Aleksejev");
        menuFile.add(menuItemAbout);
        menuBar.add(menuFile);

        t2.setBounds(40,20,270,30);
        t2.setEditable(false);
        t2.setBackground(Color.white);

        t.setBounds(40,60,270,30);
        t.setEditable(false);
        t.setBackground(Color.white);


        bclr.setBounds(40,100,60,40);
        bcos.setBounds(110,100,60,40);
        bsin.setBounds(180,100,60,40);
        bdiv.setBounds(250,100,60,40);

        b7.setBounds(40,150,60,40);
        b8.setBounds(110,150,60,40);
        b9.setBounds(180,150,60,40);
        bmul.setBounds(250,150,60,40);


        b4.setBounds(40,200,60,40);
        b5.setBounds(110,200,60,40);
        b6.setBounds(180,200,60,40);
        bsub.setBounds(250,200,60,40);

        b1.setBounds(40,250,60,40);
        b2.setBounds(110,250,60,40);
        b3.setBounds(180,250,60,40);
        badd.setBounds(250,250,60,40);

        bdif.setBounds(40,300,60,40);
        b0.setBounds(110,300,60,40);
        bdec.setBounds(180,300,60,40);
        beq.setBounds(250,300,60,40);


        f.add(t);
        f.add(t2);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bdiv);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bmul);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bsub);
        f.add(bdec);
        f.add(b0);
        f.add(beq);
        f.add(badd);
        f.add(bcos);
        f.add(bsin);
        f.add(bdif);
        f.add(bclr);

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(360,420);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setJMenuBar(menuBar);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdiv.addActionListener(this);
        bmul.addActionListener(this);
        bsub.addActionListener(this);
        bdec.addActionListener(this);
        beq.addActionListener(this);
        bcos.addActionListener(this);
        bsin.addActionListener(this);
        bdif.addActionListener(this);
        bclr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
            t.setText(t.getText().concat("1"));

        if(e.getSource()==b2)
            t.setText(t.getText().concat("2"));

        if(e.getSource()==b3)
            t.setText(t.getText().concat("3"));

        if(e.getSource()==b4)
            t.setText(t.getText().concat("4"));

        if(e.getSource()==b5)
            t.setText(t.getText().concat("5"));

        if(e.getSource()==b6)
            t.setText(t.getText().concat("6"));

        if(e.getSource()==b7)
            t.setText(t.getText().concat("7"));

        if(e.getSource()==b8)
            t.setText(t.getText().concat("8"));

        if(e.getSource()==b9)
            t.setText(t.getText().concat("9"));

        if(e.getSource()==b0)
            if(t.getText().isEmpty()){

            } else {
                t.setText(t.getText().concat("0"));

            }


        if(e.getSource()==bdec)
            if(t.getText().contains(".")){

            } else {
                if (t.getText().isEmpty()) {
                    t.setText("0.");
                } else {
                    t.setText(t.getText().concat("."));
                }
            }

        if (diff != 0 || opDone !=0){
            diff = 0;
            opDone =0;
        }

        if(e.getSource()==bdif) {
            if (t2.getText().isEmpty() && !t.getText().isEmpty()) {
                if (t.getText().contains("-")) {
                    t.setText(t.getText().replace("-", ""));
                    result = Double.parseDouble(t.getText());
                } else if (t.getText().equals("0") || t.getText().isEmpty()) {

                } else {
                    t.setText("-" + t.getText());
                    result = Double.parseDouble(t.getText());
                }
            } else if (!t2.getText().isEmpty() && t.getText().isEmpty()) {

                if (t2.getText().contains("-")) {
                    t2.setText(t2.getText().replace("-", ""));
                    result = Double.parseDouble(t2.getText());
                } else if (t2.getText().equals("0.0") || t2.getText().isEmpty()) {

                } else {
                    t2.setText("-" + t2.getText());
                    result = Double.parseDouble(t2.getText());
                }
            } else if (!t2.getText().isEmpty() && !t.getText().isEmpty()) {

                if (t.getText().contains("-")) {
                    t.setText(t.getText().replace("-", ""));
                    b = Double.parseDouble(t.getText());
                } else if (t.getText().equals("0") || t.getText().isEmpty()) {

                } else {
                    t.setText("-" + t.getText());
                    b = Double.parseDouble(t.getText());
                }
            } else {
                if (t.getText().contains("-")) {
                    t.setText(t.getText().replace("-", ""));
                    result = Double.parseDouble(t.getText());
                } else if (t.getText().equals("0") || t.getText().isEmpty()) {

                } else {
                    t.setText("-" + t.getText());
                    result = Double.parseDouble(t.getText());
                }

            }
            diff +=1;
        }

        if(e.getSource()==badd) {
            if (resDone == 0 && result == 0 || t2.getText().isEmpty()) {
                a = Double.parseDouble(t.getText());
                operator = 1;
                t.setText("");
                t2.setText(String.valueOf(a));

            } else if (resDone == 1 && result == 0) {
                a = Double.parseDouble(t2.getText());
                operator = 1;
                t.setText("");
                t2.setText(String.valueOf(a));
            } else {

                a = result;
                operator = 1;
                t.setText("");
            }
        }

        if(e.getSource()==bsub)
        {
            if (resDone == 0 && result == 0 || t2.getText().isEmpty()) {
                a = Double.parseDouble(t.getText());
                operator = 2;
                t.setText("");
                t2.setText(String.valueOf(a));
            }else if (resDone == 1 && result == 0) {
                a = Double.parseDouble(t2.getText());
                operator = 2;
                t.setText("");
                t2.setText(String.valueOf(a));
            } else {
                a = result;
                operator = 2;
                t.setText("");
            }
        }

        if(e.getSource()==bmul)
        {
            if (resDone == 0 && result == 0 || t2.getText().isEmpty()) {
                a = Double.parseDouble(t.getText());
                operator = 3;
                t.setText("");
                t2.setText(String.valueOf(a));
            }else if (resDone == 1 && result == 0) {
                a = Double.parseDouble(t2.getText());
                operator = 3;
                t.setText("");
                t2.setText(String.valueOf(a));
            } else {
                a = result;
                operator = 3;
                t.setText("");
            }
        }

        if(e.getSource()==bdiv)
        {
            if (resDone == 0 && result == 0  || t2.getText().isEmpty()) {
                a = Double.parseDouble(t.getText());
                operator = 4;
                t.setText("");
                t2.setText(String.valueOf(a));
            }else if (resDone == 1 && result == 0) {
                a = Double.parseDouble(t2.getText());
                operator = 4;
                t.setText("");
                t2.setText(String.valueOf(a));
            } else {
                a = result;
                operator = 4;
                t.setText("");
            }
        }

        if(e.getSource()==bsin)
        {
            if(t2.getText().isEmpty() && !t.getText().isEmpty()) {
                c = Double.parseDouble(t.getText());
                answer = Math.sin(c);
                t.setText(String.valueOf(answer));
                result = answer;
                opDone +=1;

            } else if (!t2.getText().isEmpty() && t.getText().isEmpty()) {

                c = Double.parseDouble(t2.getText());
                answer = Math.sin(c);
                t2.setText(String.valueOf(answer));
                result = answer;
                opDone +=1;

            } else if (!t2.getText().isEmpty() && !t.getText().isEmpty()){
                c = Double.parseDouble(t.getText());
                answer = Math.sin(c);
                t.setText(String.valueOf(answer));
                b = answer;
                opDone +=1;
            }
        }

        if(e.getSource()==bcos)
        {

            if(t2.getText().isEmpty() && !t.getText().isEmpty()) {
                c = Double.parseDouble(t.getText());
                answer = Math.cos(c);
                t.setText(String.valueOf(answer));
                result = answer;
                opDone +=1;

            } else if (!t2.getText().isEmpty() && t.getText().isEmpty()) {

                c = Double.parseDouble(t2.getText());
                answer = Math.cos(c);
                t2.setText(String.valueOf(answer));
                result = answer;
                opDone +=1;

            } else if (!t2.getText().isEmpty() && !t.getText().isEmpty()){
                c = Double.parseDouble(t.getText());
                answer = Math.cos(c);
                t.setText(String.valueOf(answer));
                b = answer;
                opDone +=1;
            }
        }

        if (resDone == 1 && operator == 0 && diff == 0 && opDone == 0) {

            result = 0;
            resDone = 0;
            operator = 0;
        }


        if(e.getSource()==beq) {

            if (result != 0) {
                a = result;
                b = Double.parseDouble(t.getText());
            }
            if ( b== 0) {
                b = Double.parseDouble(t.getText());
            }




            switch (operator) {
                case 1:
                    result = a + b;

                    break;

                case 2:
                    result = a - b;

                    break;

                case 3:
                    result = a * b;

                    break;

                case 4:
                    result = a / b;

                    break;

                default:
                    result = 0;
            }

            double check = result - (long) result;

            if (String.valueOf(check).length() > 13 && String.valueOf((long) result).length() < 6) {

                result = Math.round(result * 10_000_000_000_000.0) / 10_000_000_000_000.0;
            }

            if (result == 0){
                result = 0;
                a = 0;
            } else {
                a = result;
            }

            t.setText("");
            t2.setText("" + result);
            operator=0;
            resDone=1;
            b=0;
            opDone = 0;

        }

        if(e.getSource()==bclr) {
            t.setText("");
            t2.setText("");
            result=0;
            resDone=0;
            a=0;
            b=0;


        }
    }

    public static void main(String...s)
    {
        new Calculator();
    }
}

