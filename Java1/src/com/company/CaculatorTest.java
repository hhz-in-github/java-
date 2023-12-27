package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//实现ActionListener接口
public class CaculatorTest implements ActionListener {
    JFrame frame = new JFrame("计算器");//Swing库中的顶层窗体类
    JTextField area = new JTextField("0");//用于显示输入和计算结果
    //创建界面上的面板
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    //创建按钮数组和按钮文本数组
  //  JButton[] buttons = new JButton[20];
    String[] buttonsText = {"sqrt", "退格", "C", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0",
            ".", "+/-", "="};

    boolean point = false; // 用于判断是否输入多位小数点
    boolean key = true; // 做完运算("=")后继续输入数字
    String sign = " "; // 用于判断和记录运算符号
    double temp = 0; // 多次连续运算时，值的寄存处

    // CalculatorTest类的构造函数
    public CaculatorTest() {
        initMenu();// 初始化菜单
        initText(); // 初始化文本
        initExtend();// 初始化扩展功能
        initFrame();// 初始化窗体
        initBorderLayout(); // 初始化边框布局
    }


    // 初始化菜单
    private void initMenu() {
        JMenuBar mb = new JMenuBar();// 创建菜单栏
        JMenu m1 = new JMenu("选项");
        // 创建两个菜单项，标签分别为"普通型计算器"和"科学型计算器"
        JMenuItem m11 = new JMenuItem("普通型计算器");
        JMenuItem m12 = new JMenuItem("科学型计算器");
        // 将菜单项添加到第一个菜单中
        m1.add(m11);
        m1.add(m12);

        // 为"普通型计算器"菜单项添加点击事件监听器
     /*
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当"普通型计算器"被点击时，隐藏panel2，并重新调整窗体大小
                boolean flag = false;
                panel2.setVisible(flag);
                frame.pack();
            }
        });


        // 为"科学型计算器"菜单项添加点击事件监听器
        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当"科学型计算器"被点击时，显示panel2，并重新调整窗体大小
                boolean flag = true;
                panel2.setVisible(flag);
                frame.pack();
            }
        });
*/

        //根据idea提示使用lambda表达式来替代上述的匿名ActionListener
        m11.addActionListener(e -> {
            // 当"普通型计算器"被点击时，隐藏panel2，并重新调整窗体大小
            boolean flag = false;
            panel2.setVisible(flag);
            frame.pack();
        });
        m12.addActionListener(e -> {
            // 当"科学型计算器"被点击时，显示panel2，并重新调整窗体大小
            boolean flag = true;
            panel2.setVisible(flag);
            frame.pack();
        });

        mb.add(m1);// 将第一个菜单添加到菜单栏中
        frame.setJMenuBar(mb);// 将菜单栏设置为窗体的菜单栏
    }


    // 初始化输出文本区
    private void initText() {
        area.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        area.setSize(400, 100);
        area.setHorizontalAlignment(JTextField.RIGHT); // 向右显示
    }

    // 初始化拓展功能
    private void initExtend() {
        // 设置panel2的布局为一行四列的GridLayout，间距为1
        panel2.setLayout(new GridLayout(1, 4, 1, 1));

        // 创建四个按钮
        JButton b1 = new JButton("平方");
        JButton b2 = new JButton("1/n");
        JButton b3 = new JButton("ln");
        JButton b4 = new JButton("sin");
        JButton b5 = new JButton("cos");
        JButton b6 = new JButton("tan");

        // 设置按钮的字体样式为TimesRoman，普通样式，大小为20
        b1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        b2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        b3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        b4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        b5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        b6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        // 设置按钮的大小为100x100
        b1.setSize(100, 100);
        b2.setSize(100, 100);
        b3.setSize(100, 100);
        b4.setSize(100, 100);
        b5.setSize(100, 100);
        b6.setSize(100, 100);
        // 为按钮添加点击事件监听器，这里使用了this，表示当前类实现了ActionListener接口
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        // 将按钮添加到panel2中
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b4);
        panel2.add(b5);
        panel2.add(b6);
    }

/*
    // 初始化窗体的方法
    private void initFrame() {
        // 设置panel1的布局为五行四列的GridLayout，间距为1
        panel1.setLayout(new GridLayout(5, 4, 1, 1));

        // 遍历按钮文本数组
        for (int i = 0; i < buttonsText.length; i++) {
            // 创建按钮
            JButton button = new JButton(buttonsText[i]);
            button.setSize(100, 100);// 设置按钮的大小
            button.setFont(new Font("TimesRoman", Font.PLAIN, 20));// 设置按钮的字体样式
            button.addActionListener(this);// 为按钮添加点击事件监听器

            // 将按钮添加到panel1中
            panel1.add(button);
        }
    }*/
    // 初始化窗体的方法
    private void initFrame() {
        // 设置panel1的布局为五行四列的GridLayout，间距为1
        panel1.setLayout(new GridLayout(5, 4, 1, 1));

        // 遍历按钮文本数组
        for (String buttonText : buttonsText) {
            // 创建按钮
            JButton button = new JButton(buttonText);
            button.setSize(100, 100); // 设置按钮的大小
            button.setFont(new Font("TimesRoman", Font.PLAIN, 20)); // 设置按钮的字体样式
            button.addActionListener(this); // 为按钮添加点击事件监听器

            // 将按钮添加到panel1中
            panel1.add(button);
        }
    }


    // 初始化计算器总基本界面
    private void initBorderLayout() {
        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.SOUTH); // 插入组件
        frame.add(area, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setLocation(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setSize(700, 700);
        frame.setVisible(true); // 设置可见
        panel2.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 可以关闭
        frame.pack();
    }





    public static void main(String[] args) {
        new CaculatorTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取按钮的文本
        String str = e.getActionCommand();
        // 获取当前显示区域的文本
        String str2 = area.getText();

        // 处理数字按钮的点击事件
        if (str.equals("0") || str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5") || str.equals("6") || str.equals("7")
                || str.equals("8") || str.equals("9")) {
            if (key == false) {
                area.setText(str2 + str);
            } else {
                area.setText(str);
                key = false;
            }
        }
        // 处理清除按钮的点击事件
        else if (str.equals("C")) {
            area.setText("0");
            sign = " ";
            key = true;
        }
        // 处理小数点按钮的点击事件
        else if (str.equals(".")) {
            if (!point) {
                area.setText(str2 + str);
                point = true;
            } else {
                area.setText("重复输入小数点！按C重置");
                point = false;
            }
        }
        // 处理正负号按钮的点击事件
        else if (str.equals("+/-")) {
            double num = Double.valueOf(str2);
            num = -num;
            area.setText(String.valueOf(num));
        }
        // 处理退格按钮的点击事件
        else if (str.equals("退格")) {
            if (str2.length() == 0) {
                area.setText("不能删除了！按C重置");
            } else {
                str2 = str2.substring(0, str2.length() - 1);
                area.setText(str2);
            }
        }
        // 处理平方根按钮的点击事件
        else if (str.equals("sqrt")) {
            double num = Double.valueOf(str2);
            num = Math.sqrt(num);
            area.setText(String.valueOf(num));
        }
        // 处理sin按钮的点击事件
        else if (str.equals("sin")) {
            area.setText("");
            sign = "sin";
        }
        // 处理cos按钮的点击事件
        else if (str.equals("cos")) {
            area.setText("");
            sign = "cos";
        }
        // 处理exp按钮的点击事件
        else if (str.equals("exp")) {
            area.setText("");
            sign = "exp";
        }
        // 处理ln按钮的点击事件
        else if (str.equals("ln")) {
            area.setText("");
            sign = "ln";
        }
        // 处理平方按钮的点击事件
        else if (str.equals("平方")) {
            double num = Double.valueOf(str2);
            num = num * num;
            area.setText(String.valueOf(num));
        }
        // 处理幂按钮的点击事件
        else if (str.equals("幂")) {
            area.setText("");
            sign = "幂";
        }
        // 处理倒数按钮的点击事件
        else if (str.equals("1/n")) {
            double num = Double.valueOf(str2);
            if (num == 0) {
                area.setText("被除数不能为0哦！按C");
            } else {
                num = 1 / num;
                area.setText(String.valueOf(num));
            }
        }
        // 处理其他运算符和等号按钮的点击事件
        else {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                performBasicCalculation(str, str2);
            } else if (str.equals("=")) {
                performEqualsOperation(str2);
            }
        }
    }

    // 执行基本的四则运算
    private void performBasicCalculation(String operator, String currentInput) {
        if (sign.equals(" ")) {
            sign = operator;
            temp = Double.valueOf(currentInput);
            area.setText("");
        } else {
            performPreviousOperation(currentInput);
            sign = operator;
            key = true;
        }
    }

    // 执行之前的运算
    private void performPreviousOperation(String currentInput) {
        if (sign.equals("+")) {
            temp = temp + Double.valueOf(currentInput);
        } else if (sign.equals("-")) {
            temp = temp - Double.valueOf(currentInput);
        } else if (sign.equals("*")) {
            temp = temp * Double.valueOf(currentInput);
        } else if (sign.equals("/")) {
            if (Double.valueOf(currentInput) == 0) {
                area.setText("除数不能为0哦！按C");
            } else {
                temp = temp / Double.valueOf(currentInput);
            }
        } else if (sign.equals("s")) {
            temp = Math.sqrt(Double.valueOf(currentInput));
        } else if (sign.equals("sin")) {
            temp = Math.sin(Double.valueOf(currentInput));
        } else if (sign.equals("cos")) {
            temp = Math.cos(Double.valueOf(currentInput));
        } else if (sign.equals("exp")) {
            temp = Math.exp(Double.valueOf(currentInput));
        } else if (sign.equals("ln")) {
            temp = Math.log(Double.valueOf(currentInput));
        }
    }

    // 执行等号操作
    private void performEqualsOperation(String currentInput) {
        if (!sign.equals(" ")) {
            performPreviousOperation(currentInput);
            area.setText(String.valueOf(temp));
            sign = " ";
            key = true;
        }
    }
}