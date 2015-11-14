package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by zhangsirui on 15/9/15.
 */
public class Test_circle extends JFrame{
    MyPanel myPanel;
    public static void main(String[] args)
    {
        Test_circle test_circle=new Test_circle();
    }
    public Test_circle()
    {
        myPanel=new MyPanel();
        this.add(myPanel);

        this.addKeyListener(myPanel);
        this.addMouseListener(myPanel);

        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MyPanel extends JPanel implements KeyListener,MouseListener
{
    int x=10;
    int y=10;
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        graphics.fillOval(x,y,10,10);
    }

    //表示会打印出的键被按下
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_UP)
        {
            y--;
        }else if (e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            y++;
        }else if (e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            x--;
        }else if (e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            x++;
        }
        //调用repaint函数来重绘,否则不会发生变化
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标点击了：x="+e.getX()+" y="+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
