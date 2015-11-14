package com.company;

import javafx.util.Pair;
import sun.rmi.transport.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by zhangsirui on 15/9/15.
 */
public class Test{


    public static void main(String[] args)throws Exception
    {
        //1、加载驱动，使用反射知识
        Class.forName("com.mysql.jdbc.Driver");
        try(//2、使用DriverManager获取数据库连接
            //其中返回的Connection代表了Java程序与数据库的连接
            //不同数据库的URL连接需要查驱动文档，用户名、密码由DBA分配
            java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Student","root","1234");
            //3、使用Connection建立一个Statement对象
            Statement statement=connection.createStatement();
            //4、执行SQL语句
            ResultSet resultSet=statement.executeQuery("SELECT * FROM student WHERE id=1")
        ){
            while (resultSet.next())
            {
                System.out.println(resultSet);
            }

        }
    }

}
