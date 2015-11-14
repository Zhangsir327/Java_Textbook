package com.company;

/**
 * Created by zhangsirui on 15/10/9.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.util.Random;

public class Gobang{
    //定义棋盘大小
    private static int BOARD_SIZE=15;
    //定义一个二维数组来充当棋盘
    private String[][] board;
    //初始化棋盘
    public void initBoard()
    {
        //初始化棋盘数组
        board=new String[BOARD_SIZE][BOARD_SIZE];
        //为每个元素赋为“+”，用于在控制台画出棋盘
        for(int i=0;i<BOARD_SIZE;i++)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                board[i][j]="+";
            }
        }
    }
    //在控制台输出棋盘的方法
    public void printBoard()
    {
        //打印每个数组元素
        for(int i=0;i<BOARD_SIZE;i++)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                System.out.print(board[i][j]);
            }
            //每打印完一行数组后输出一个换行符
            System.out.print("\n");
        }
    }
    //电脑下棋
    public void computer()
    {
        //生成两个随机数，作为下棋的x，y坐标
        Random random=new Random(System.currentTimeMillis());
        int xPos=random.nextInt(14);
        int yPos=random.nextInt(14);
        //下棋的点，不能重复下
        while(board[xPos][yPos]!="+")
        {
            xPos=random.nextInt(14);
            yPos=random.nextInt(14);
        }
        //把对应的数组元素赋为“○”
        this.board[xPos][yPos]="○";
    }
    //判断输赢
    public boolean judge(int xPos,int yPos)
    {
        int count=0;//同一直线上相同棋子的累积数
        boolean flag=false;//用flag来记录是否赢
        int i=0;
        //纵向判断
        while((xPos+i)<15&&(board[xPos][yPos].equals(board[xPos+i][yPos])))
        {
            count++;
            if(count==5)
            {
                flag=true;
                break;
            }
            i++;
        }
        i=0;
        while((xPos-i)>=0&&(board[xPos][yPos].equals(board[xPos-i][yPos])))
        {
            count++;
            if(count==5)
            {
                flag=true;
                break;
            }
            i++;
        }

        //横向判断
        i=0;
        count=0;
        while((yPos+i)<15&&(board[xPos][yPos].equals(board[xPos][yPos+i])))
        {
            count++;
            if(count==5)
            {
                flag=true;
                break;
            }
            i++;
            System.out.println("循环1 "+count);
        }
        i=1;
        while((yPos-i)>=0&&(board[xPos][yPos].equals(board[xPos][yPos-i])))
        {
            count++;
            if(count==5)
            {
                flag=true;
                break;
            }
            i++;
            System.out.println("循环2 "+count);
        }

        //左斜向判断
        i=0;
        count=0;
        while((yPos+i)<15&&(xPos-i)>=0&&(board[xPos][yPos].equals(board[xPos-i][yPos+i])))
        {
            count++;
            if(count==5)
            {
                flag=true;
                break;
            }
            i++;
        }
        i=0;
        while((yPos-i)>=0&&(xPos+i)<15&&(board[xPos][yPos].equals(board[xPos+i][yPos-i])))
        {
            count++;
            if(count==5)
            {
                flag=true;
                break;
            }
            i++;
        }

        return flag;
    }
    public static void main(String[] args)throws Exception
    {
        Gobang gobang=new Gobang();
        gobang.initBoard();
        gobang.printBoard();
        //这是用于获取键盘输入的方法
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String inputStr=null;
        while((inputStr=br.readLine())!=null)
        {
            //将用户输入的字符串以“，”作为分隔符，分隔成两个字符串
            String[] pos=inputStr.split(",");
            //将两个字符串转换为用户下棋的坐标
            int xPos=Integer.parseInt(pos[0]);
            int yPos=Integer.parseInt(pos[1]);
            //把对应的数组元素赋为“●”
            gobang.board[xPos-1][yPos-1]="●";
					/*
					电脑随机生成2个整数，作为电脑下棋的坐标，赋给board数组
					还涉及
					1、坐标的有效性，只能是数字，不能超出棋盘范围
					2、下棋的点，不能重复下
					3、每次下棋后，需要扫描谁赢了
					*/
            boolean flag=gobang.judge(xPos-1,yPos-1);
            if(flag==true)
                break;
            gobang.computer();
            gobang.printBoard();
            System.out.println("请输入您下棋的坐标，应以x、y的格式：");
        }
        System.out.println("玩家赢");
    }
}

