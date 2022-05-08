import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener {
    private final String[] KEYS = { "7", "8", "9", "AC",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", "e", "pi", "/", "sqrt",
            "%", "x*x", "*", "(", ")", ".", "=" };
    private JButton keys[] = new JButton[KEYS.length];
    private JTextArea resultText = new JTextArea("0.0");
    private JScrollPane gdt1=new JScrollPane(resultText);
    private String b = "";
    public Calculator() {
        super("计算器");
        resultText.setAlignmentX(RIGHT_ALIGNMENT);
        resultText.setEditable(false);
        JPanel jp1 = new JPanel();
        jp1.setBounds(20,18,255,115);
        jp1.setLayout(new GridLayout());
        resultText.setLineWrap(true);
        resultText.setWrapStyleWord(true);
        resultText.setFont(new Font("宋体",Font.BOLD,20));
        jp1.add(gdt1);
        this.add(jp1);
        this.setLayout(null);
        int x = 20, y = 150;
        for (int i = 0; i < KEYS.length; i++)
        {
            keys[i] = new JButton();
            keys[i].setText(KEYS[i]);
            keys[i].setBounds(x, y, 60, 40);
            if (x < 215) {
                x += 65;
            } else {
                x = 20;
                y += 45;
            }
            this.add(keys[i]);
        }
        for (int i = 0; i < KEYS.length; i++)
        {
            keys[i].addActionListener(this);
        }
        this.setResizable(false);
        this.setBounds(500, 200, 310, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String label=e.getActionCommand();
        if(Objects.equals(label, "="))
        {
            resultText.setText(this.b);
            if(label.equals("="))
            {
                String[] s =houzhui(this.b);
                String result=Result(s);
                this.b=result+"";
                resultText.setText(this.b);
            }
        }
        else if(Objects.equals(label, "AC"))
        {
            this.b="";
            resultText.setText("0");
        }
        else if(Objects.equals(label, "sqrt"))
        {
            String n=kfys(this.b);
            resultText.setText("sqrt"+"("+this.b+")"+"="+n);
            this.b=n;
        }
        else if(Objects.equals(label, "x*x"))
        {
            String m=pfys(this.b);
            resultText.setText(this.b+"^2"+"="+m);
            this.b=m;
        }
        else if(Objects.equals(label, "e") || Objects.equals(label, "pi"))
        {
            if(label.equals("e"))
            {
                String m=String.valueOf(2.71828);
                this.b=this.b+m;
                resultText.setText(this.b);
            }
            if(label.equals("pi"))
            {
                String m=String.valueOf(3.14159265);
                this.b=this.b+m;
                resultText.setText(this.b);
            }
        }
        else
        {
            this.b=this.b+label;
            resultText.setText(this.b);
        }
    }
    private String[] houzhui(String str) {
        String s = "";
        char[] opStack = new char[100];
        String[] postQueue = new String[100];
        int top = -1, j = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if ("0123456789.".indexOf(str.charAt(i)) >= 0)
            {
                s = "";
                for (; i < str.length() &&
                    "0123456789.".indexOf(str.charAt(i)) >= 0; i++) {
                    s = s + str.charAt(i);
                }
                i--;
                postQueue[j] = s;
                j++;
            }
            else if ("(".indexOf(str.charAt(i)) >= 0) {
                top++;
                opStack[top] = str.charAt(i);
            }
            else if (")".indexOf(str.charAt(i)) >= 0) {
                for (;;)
                {
                    if (opStack[top] != '(') {
                        postQueue[j] = opStack[top] + "";
                        j++;
                        top--;
                    } else {
                        top--;
                        break;
                    }
                }
            }
            else if ("*%/+-".indexOf(str.charAt(i)) >= 0)
            {
                if (top == -1)
                {
                    top++;
                    opStack[top] = str.charAt(i);
                }
                else if ("*%/".indexOf(opStack[top]) >= 0)
                {
                    postQueue[j] = opStack[top] + "";
                    j++;
                    opStack[top] = str.charAt(i);
                }
                else
                {
                    top++;
                    opStack[top] = str.charAt(i);
                }
            }
        }
        while (top != -1) {
            postQueue[j] = opStack[top] + "";
            j++;
            top--;
        }
        return postQueue;
    }
    public String kfys(String str) {
        String result = "";
        double a = Double.parseDouble(str), b = 0;
        b = Math.sqrt(a);
        result = String.valueOf(b);
        return result;
    }
    public String pfys(String str) {
        String result = "";
        double a = Double.parseDouble(str), b = 0;
        b = Math.pow(a, 2);
        result = String.valueOf(b);
        return result;
    }
    public String Result(String[] str) {
        String[] Result = new String[100];
        int Top = -1;
        for (int i = 0; str[i] != null; i++) {
            if (!"+-*%/".contains(str[i])) {
                Top++;
                Result[Top] = str[i];
            }
            if ("+-*%/".contains(str[i]))
            {
                double x, y, n;
                x = Double.parseDouble(Result[Top]);
                Top--;
                y = Double.parseDouble(Result[Top]);
                Top--;
                if ("*".contains(str[i])) {
                    n = y * x;
                    Top++;
                    Result[Top] = String.valueOf(n);
                }
                if ("/".contains(str[i]))
                {
                    if (x == 0)
                    {
                        String s = "error!";
                        return s;
                    } else {
                        n = y / x;
                        Top++;
                        Result[Top] = String.valueOf(n);
                    }
                }
                if ("%".contains(str[i]))
                {
                    if (x == 0)
                    {
                        String s = "error!";
                        return s;
                    } else {
                        n = y % x;
                        Top++;
                        Result[Top] = String.valueOf(n);
                    }
                }
                if ("-".contains(str[i])) {
                    n = y - x;
                    Top++;
                    Result[Top] = String.valueOf(n);
                }
                if ("+".contains(str[i])) {
                    n = y + x;
                    Top++;
                    Result[Top] = String.valueOf(n);
                }
            }
        }
        return Result[Top];
    }
    public static void main(String[] args) {
        Calculator a = new Calculator();
    }
}

