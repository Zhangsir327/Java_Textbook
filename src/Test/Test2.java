package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;


/**
 * Created by zhangsirui on 15/9/22.
 */
public class Test2 {
    JFrame jFrame=new JFrame("test");
    //定义一个按钮。并为之指定图标
    Icon okIcon=new ImageIcon("Ico/ok.png");
    JButton ok=new JButton("确认");
    //定义一个单选按钮，初始处于选中状态
    JRadioButton male=new JRadioButton("男",true);
    //定义一个单选按钮，初始处于未选中状态
    JRadioButton female=new JRadioButton("女",false);
    //定义一个ButtonGroup用于将上面两个JRadioButton组合起来
    //ButtonGroup中只有一个可以是选中的，其余都是未被选中的
    ButtonGroup buttonGroup=new ButtonGroup();
    //定义一个复选框，初始处于没有选中状态
    JCheckBox married=new JCheckBox("是否已婚？",false);

    String[] colors=new String[]{"红色","绿色","蓝色"};
    //定义一个下拉选择框
    JComboBox<String> colorChooser=new JComboBox<String>(colors);
    //定义一个列表选择框
    JList<String> colorList=new JList<String>(colors);
    //定义一个8行、20列的多行文本域
    JTextArea jTextArea=new JTextArea(8,20);
    //定义一个40列的单行文本域
    JTextField name=new JTextField(40);

    JMenuBar jMenuBar=new JMenuBar();
    JMenu file=new JMenu("文件");
    JMenu edit=new JMenu("编辑");
    //创建新建菜单，并为之指定图标
    Icon newIcon=new ImageIcon("ico/new.png");
    JMenuItem newItem=new JMenuItem("新建",newIcon);
    //创建保存菜单项，并为之指定图标
    Icon saveIcon=new ImageIcon("ico/save.png");
    JMenuItem saveItem=new JMenuItem("保存",saveIcon);
    //创建退出菜单项
    Icon exitIcon=new ImageIcon("ico/exit.png");
    JMenuItem exitItem=new JMenuItem("退出",exitIcon);
    JCheckBoxMenuItem autoWrap=new JCheckBoxMenuItem("自动换行");
    //创建复制菜单项，并为之指定图标
    Icon copyIcon=new ImageIcon("ico/copy.png");
    JMenuItem copyItem=new JMenuItem("复制",copyIcon);
    //创建粘贴菜单项，并为之指定图标
    JMenuItem pasteItem=new JMenuItem("粘贴",new ImageIcon("ico/paste.png"));
    JMenu format=new JMenu("格式");
    JMenuItem commentItem=new JMenuItem("注释");
    JMenuItem cancelItem=new JMenuItem("取消注释");

    //定义一个右键菜单用于设置程序风格
    JPopupMenu jPopupMenu=new JPopupMenu();
    //用于组合三个风格菜单项的ButtonGroup
    ButtonGroup flavorGroup=new ButtonGroup();
    //创建5个单选按钮，用于设定程序的风格
    JRadioButtonMenuItem metalItem=new JRadioButtonMenuItem("metal风格",true);
    JRadioButtonMenuItem nimbusItem=new JRadioButtonMenuItem("nimbus风格");
    JRadioButtonMenuItem windowsItem=new JRadioButtonMenuItem("windows风格");
    JRadioButtonMenuItem classicItem=new JRadioButtonMenuItem("windows经典风格");
    JRadioButtonMenuItem motifItem=new JRadioButtonMenuItem("motif风格");


    public void init()
    {
        //创建一个装载了文本框、按钮的JPanel
        JPanel bottom=new JPanel();
        bottom.add(name);
        bottom.add(ok);
        jFrame.add(bottom,BorderLayout.SOUTH);

        //创建一个装载了下拉选择框、三个JCheckBox的JPanel
        JPanel checkPanel=new JPanel();
        buttonGroup.add(male);
        buttonGroup.add(female);
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);
        //创建一个垂直排列组件的Box，盛装多行文本域JPanel
        Box topLeft=Box.createVerticalBox();
        //使用JScrollPane作为普通组件的JViewPort
        //如果需要组件带滚动条，可以将它放入JScrollPane中
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        topLeft.add(jScrollPane);
        topLeft.add(checkPanel);
        //创建一个水平排列组件的Box，用于盛装topLeft、colorList
        Box top=Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        //将top Box容器添加到窗口中间
        jFrame.add(top);

        //--------------下面开始组合菜单，并为菜单添加监听器----------------
        //为newItem设置快捷键，设置快捷键时要使用大写字母
        //注意Swing组件和AWT组件在设置快捷键上的不同！！！
        newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
        newItem.addActionListener(e->{
            jTextArea.append("用户单击了 新建 菜单\n");
        });
        //为file菜单添加菜单项
        file.add(newItem);
        file.add(exitItem);
        file.add(saveItem);
        //为edit菜单添加菜单项
        edit.add(autoWrap);
        //使用addSeparator（）方法添加分隔符
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);
        //为commentItem组件添加提示信息
        commentItem.setToolTipText("将程序代码注释起来");
        //为format菜单添加菜单项
        format.add(commentItem);
        format.add(cancelItem);
        //使用添加new JMenuItem("-")的方法不能添加菜单分隔符！！！！
        edit.add(new JMenuItem("-"));
        //将format菜单组合到edit菜单中，从而形成二级菜单
        edit.add(format);
        //将file、edit添加到MenuBar菜单条中
        jMenuBar.add(file);
        jMenuBar.add(edit);
        //为JFrame窗口设置菜单条
        jFrame.setJMenuBar(jMenuBar);

        //-----------下面开始组合右键菜单，并安装右键菜单----------------
        flavorGroup.add(metalItem);
        flavorGroup.add(nimbusItem);
        flavorGroup.add(windowsItem);
        flavorGroup.add(classicItem);
        flavorGroup.add(motifItem);
        jPopupMenu.add(metalItem);
        jPopupMenu.add(nimbusItem);
        jPopupMenu.add(windowsItem);
        jPopupMenu.add(classicItem);
        jPopupMenu.add(motifItem);
        //为5个风格菜单创建事件监听器
        ActionListener flavorListener=e->{
            try{
                switch (e.getActionCommand())
                {
                    case "metal风格":
                        changeFlavor(1);
                        break;
                    case "nimbus风格":
                        changeFlavor(2);
                        break;
                    case "windows风格":
                        changeFlavor(3);
                        break;
                    case "window经典风格":
                        changeFlavor(4);
                        break;
                    case "motif风格":
                        changeFlavor(5);
                        break;
                }
            }catch (Exception ee)
            {
                ee.printStackTrace();
            }
        };
        //为5个风格菜单设置事件监听器
        metalItem.addActionListener(flavorListener);
        nimbusItem.addActionListener(flavorListener);
        windowsItem.addActionListener(flavorListener);
        classicItem.addActionListener(flavorListener);
        motifItem.addActionListener(flavorListener);
        //调用该方法即可设置右键菜单，无需使用事件机制
        jTextArea.setComponentPopupMenu(jPopupMenu);
        //设置关闭窗口时，退出程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    //定义一个方法，用于改变界面风格
    public void changeFlavor(int flavor)throws Exception
    {
        switch (flavor)
        {
            case 1:
                //设置Metal风格
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case 2:
                //设置Nimbus风格
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.nimbusLookAndFeel");
                break;
            case 3:
                //设置Windows风格
                UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case 4:
                //设置Windows经典风格
                UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case 5:
                //设置Motif风格
                UIManager.setLookAndFeel("javax.swing.plaf.motif.MotifLookAndFeel");
                break;
        }
        //更新JFrame窗口内顶级容器以及内部所有组件的UI
        SwingUtilities.updateComponentTreeUI(jFrame.getContentPane());
        //更新JMenuBar菜单条以及内部所有组件的UI
        SwingUtilities.updateComponentTreeUI(jMenuBar);
        //更新JPopupMenu右键菜单以及内部所有组件的UI
        SwingUtilities.updateComponentTreeUI(jPopupMenu);
    }
    public static void main(String[] args)
    {
        //设置Swing窗口使用Java风格
        //JFrame.setDefaultLookAndFeelDecorated(true);
        new Test2().init();
    }
}


