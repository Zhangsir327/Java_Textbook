package com.company;

import sun.tools.jconsole.BorderedComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    JButton jButton1,jButton2;
    JLabel jLabel1,jLabel2;
    JTextField jTextField;
    JPasswordField jPasswordField;
    JPanel jPanel1,jPanel2,jPanel3;

    public static void main(String[] args) {
	// write your code here
        Main main=new Main();
    }


    public Main()
    {
        /*//create a button
        jButton1=new JButton("North");
        jButton2=new JButton("South");
        jButton3=new JButton("West");
        jButton4=new JButton("East");
        jButton5=new JButton("Center");

        /*
        this.add(jButton1, BorderLayout.NORTH);
        this.add(jButton2,BorderLayout.SOUTH);
        this.add(jButton3,BorderLayout.WEST);
        this.add(jButton4,BorderLayout.EAST);
        this.add(jButton5,BorderLayout.CENTER);

        this.setTitle("BorderLayout");
        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel1=new JPanel();
        jPanel2=new JPanel();

        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel2.add(jButton5);
        jPanel2.add(jButton3);

        this.add(jPanel1, BorderLayout.NORTH);
        this.add(jButton4,BorderLayout.CENTER);
        this.add(jPanel2,BorderLayout.SOUTH);

        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        jPanel1=new JPanel();
        jPanel2=new JPanel();
        jPanel3=new JPanel();

        jLabel1=new JLabel("username");
        jLabel2=new JLabel("password");

        jTextField=new JTextField(10);
        jPasswordField=new JPasswordField(10);

        jButton1=new JButton("Login");
        jButton2=new JButton("cancel");

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);
        jPanel2.add(jLabel2);
        jPanel2.add(jPasswordField);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);

        this.setLayout(new GridLayout(3,1));

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);

        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
