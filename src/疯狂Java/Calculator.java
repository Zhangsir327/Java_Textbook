package 疯狂Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * Created by zhangsirui on 15/10/12.
 * 计算器1.0
 * 还需增加异常处理、修改界面、增加按键及功能
 */
public class Calculator {
    JFrame jFrame=new JFrame("简单计算器");
    JPanel jPanel=new JPanel();
    //JTextField screen=new JTextField(10);
    JTextArea screen=new JTextArea(1,10);
    String[] buttonName = new String[]{"C","+/-","%","/","7", "8", "9", "*","4", "5", "6", "-","1", "2", "3",  "+"
            , "0"," ",".","="};
    JButton[] buttons=new JButton[20];
    //设置一个ArrayDeque，来存储按下的数字
    Deque<String> numbers=new ArrayDeque<>();
    //设置另一个ArrayDeque，用于存储按下的运算符
    Deque<String> operators=new ArrayDeque<>();
    //设置一个暂存字符串，用于保存当前已按下的数字
    String tempString="";
    public void init()
    {
        jFrame.add(screen);
        jPanel.setLayout(new GridLayout(5,4));
        jFrame.add(jPanel,BorderLayout.SOUTH);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);



        //创建事件监听器
        ActionListener myListener=e->{
            String string=e.getActionCommand();

            if (string.matches("(\\d|\\.)"))
            {
                tempString+=string;
                screen.setText(tempString);
            }else if (string.matches("(\\+|\\-|\\*|\\/|\\=)"))
            {
                handleNumber(tempString);
                handleOperator(string);
            }else if(string.matches("C"))
            {
                handleC();
            }
        };
        for (int i=0;i<buttonName.length;i++)
        {
            buttons[i]=new JButton(buttonName[i]);
            buttons[i].addActionListener(myListener);
            jPanel.add(buttons[i]);
        }
    }
    //处理按下的数字或小数点
    public void handleNumber(String string)
    {
        screen.setText(string);
        //将按下的数字入栈
        //当暂存字符串不为空时才入栈
        if (tempString!="")
        {
            numbers.push(string);
        }
        //将暂存字符串置为空
        tempString="";
    }
    //处理按下的运算符
    public void handleOperator(String string)
    {
        //如果运算符不是等号，则入栈
        //如果是等号，则从numbers栈中弹出两个元素，从operators栈中弹出一个元素
        //运算完之后，将计算结果入numbers栈
        if (string.equals("="))
        {

//            int secondNum=Integer.parseInt(numbers.pop());
//            int firstNum=Integer.parseInt(numbers.pop());
            float secondNum=Float.parseFloat(numbers.pop());
            float firstNum=Float.parseFloat(numbers.pop());
            float temp=0;
            String operator=operators.pop();
            if (operator.equals("+"))
            {
                temp=firstNum+secondNum;
                screen.setText(temp + "");
            }else if (operator.equals("-"))
            {
                temp=firstNum-secondNum;
                screen.setText(temp + "");
            }else if(operator.equals("*"))
            {
                temp=firstNum*secondNum;
                screen.setText(temp + "");
            }else if (operator.equals("/"))
            {
                temp=firstNum/secondNum;
                screen.setText(temp + "");
            }
            numbers.push(String.valueOf(temp));
        }else if (string.matches("(\\+|\\-|\\*|\\/)"))
        {
            operators.push(string);
        }
    }
    //处理C按钮
    public void handleC()
    {
        screen.setText("");
        numbers.clear();
        operators.clear();
    }
    public static void main(String[] args)
    {
        new Calculator().init();
    }
}
