package 疯狂Java.仿Windows记事本;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by zhangsirui on 15/10/18.
 * 记事本小工具
 */
public class TextBook {
    JFrame jFrame=new JFrame("记事本");
    JPanel jPanel=new JPanel();
    JTextArea jTextArea=new JTextArea();
    //定义菜单栏
    JMenuBar jMenuBar=new JMenuBar();
    JMenu file=new JMenu("文件");
    JMenu edit=new JMenu("编辑");
    JMenu format=new JMenu("格式");
    JMenu check=new JMenu("查看");
    JMenu help=new JMenu("帮助");

    //-----文件菜单栏下的控件-----
    JMenuItem newItem=new JMenuItem("新建");
    JMenuItem openItem=new JMenuItem("打开");
    JMenuItem saveItem=new JMenuItem("保存");
    JMenuItem saveOtherItem=new JMenuItem("另存为");
    JMenuItem pageSetupItem=new JMenuItem("页面设置");
    JMenuItem exitItem=new JMenuItem("退出");
    //设置保存菜单项的对话框

    JTextField savePath=new JTextField(10);
    JButton saveButton=new JButton("保存");
    JButton cancelButton=new JButton("取消");


    //编辑菜单栏下的控件
    JMenuItem withdrawItem=new JMenuItem("撤销");
    JMenuItem cutItem=new JMenuItem("剪切");
    JMenuItem copyItem=new JMenuItem("复制");
    JMenuItem pasteItem=new JMenuItem("粘贴");

    //格式菜单栏下的控件
    JMenuItem newlineItem=new JMenuItem("自动换行");
    JMenuItem typefaceItem=new JMenuItem("字体");

    //查看菜单栏下的控件
    JMenuItem stateItem=new JMenuItem("查看状态");

    //帮助菜单栏下的控件
    JMenuItem checkHelpItem=new JMenuItem("查看帮助");
    JMenuItem aboutItem=new JMenuItem("关于记事本");


    public void init()
    {
        //将文本框放在底下
        //为文本框添加滚动条
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        jFrame.add(jScrollPane);

        //添加菜单栏
        //为file菜单添加菜单项
        file.add(newItem);
        file.add(openItem);
        file.add(saveItem);
        file.add(saveOtherItem);
        file.addSeparator();
        file.add(pageSetupItem);
        file.add(exitItem);
        //为save菜单项设置对话框

        //-------为file菜单添加事件监听器------
        //为新建菜单添加事件监听器
        newItem.addActionListener(e->{
            System.out.println("用户新建了一个文件！！");
            //功能有待添加
        });
        //为打开菜单添加事件监听器
        openItem.addActionListener(e->{
            System.out.println("用户打开了一个文件！！");
        });
        //为保存菜单添加事件监听器
        saveItem.addActionListener(e->{
            System.out.println("用户保存了文件！！");

        });
        //为退出菜单项添加事件监听器
        exitItem.addActionListener(e-> {
                    System.out.println("用户想要退出！！");
                    int result = JOptionPane.showConfirmDialog(jFrame, "are you sure to exit?", "exit", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == 0)
                        System.exit(0);
                });
        //为edit菜单添加菜单项

        //--------为help菜单添加事件监听器---------
        //为关于菜单项添加事件监听器
        aboutItem.addActionListener(e->{
            System.out.println("用户点了关于");
            JOptionPane.showMessageDialog(jFrame,"天才的记事本程序","about TextBook",JOptionPane.INFORMATION_MESSAGE);
        });

        edit.add(withdrawItem);
        edit.addSeparator();
        edit.add(cutItem);
        edit.add(copyItem);
        edit.add(pasteItem);

        //为format菜单添加菜单项
        format.add(newlineItem);
        format.add(typefaceItem);

        //为check菜单添加菜单项
        check.add(stateItem);

        //为help菜单添加菜单项
        help.add(checkHelpItem);
        help.add(aboutItem);

        jMenuBar.add(file);
        jMenuBar.add(edit);
        jMenuBar.add(format);
        jMenuBar.add(check);
        jMenuBar.add(help);

        //为JFrame设置JMenuBar菜单条
        jFrame.setJMenuBar(jMenuBar);

        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new TextBook().init();
    }

}
