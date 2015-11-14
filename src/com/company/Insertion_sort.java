package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by zhangsirui on 15/9/14.
 * 插入排序，正序+逆序
 */
public class Insertion_sort extends JFrame implements ActionListener{
    JLabel jLabel1,jLabel2;
    JTextField jTextField1,jTextField2;
    JButton jButton;
    JPanel jPanel1,jPanel2,jPanel3;
    public static void main(String[] args)
    {
//        //从控制台读入一个整型数组
//        System.out.println("please input an array:");
//        Scanner scanner=new Scanner(System.in);
//        String str=scanner.nextLine();
//        String[] strings=str.trim().split("\\s{1,}");
//        int[] a=new int[strings.length];
//        for (int i=0;i<strings.length;i++)
//        {
//            a[i]=Integer.parseInt(strings[i]);
//        }

        //插入排序
        //正序
//        for (int i=1;i<a.length;i++)
//        {
//            int key=a[i];
//            int j=i-1;
//            while (j>=0&&a[j]>key)
//            {
//                a[j+1]=a[j];
//                j=j-1;
//            }
//            a[j+1]=key;
//        }
//        //逆序
//        for (int i=a.length-1;i>=0;i--)
//        {
//            int key=a[i];
//            int j=i+1;
//            while(j<=a.length-1&&a[j]>key)
//            {
//                a[j-1]=a[j];
//                j=j+1;
//            }
//            a[j-1]=key;
//        }
//        //打印数组
//        for (int i=0;i<a.length;i++)
//        {
//            System.out.print(a[i]+" ");
//        }
        Insertion_sort insertion_sort=new Insertion_sort();

    }

    public Insertion_sort()
    {
        jPanel1=new JPanel();
        jPanel2=new JPanel();
        jPanel3=new JPanel();

        jLabel1=new JLabel("待排数列");
        jLabel2=new JLabel("输出数列");
        jTextField1=new JTextField(10);
        jTextField2=new JTextField(10);
        jButton=new JButton("排序");

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        jPanel3.add(jButton);

        this.setLayout(new GridLayout(3,1));

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);

        this.setSize(500,300);
        this.setTitle("插入排序");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jButton.addActionListener(this);
        jButton.setActionCommand("jb");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("jb"))
        {
            //获取文本框内的数据
            String string=jTextField1.getText();
            String[] strings=string.trim().split("\\s{1,}");
            int[] a=new int[strings.length];
            for (int i=0;i<a.length;i++)
            {
                a[i]=Integer.parseInt(strings[i]);
            }

            //进行插入排序
            for (int i=1;i<a.length;i++)
            {
                int key=a[i];
                int j=i-1;
                while (j>=0&&a[j]>key)
                {
                    a[j+1]=a[j];
                    j=j-1;
                }
                a[j+1]=key;
            }

            //数列输出

        }
    }
}
