package 疯狂Java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangsirui on 15/10/19.
 */
public class MultiThreadPrint {
    private boolean flag=false;
    private int i=1;
    private int j=0;
    class DigitPrint extends Thread
    {
        @Override
        public void run() {
            for (;i<27;)
            {
                printDigit();
            }
        }
    }
    class LetterPrint extends Thread
    {
        @Override
        public void run() {
            for (;j<26;)
            {
                printLetter();
            }
        }
    }
    public synchronized void printDigit()
    {
        try {
            if (flag)
            {
                wait();
            }else {
                System.out.print(i);
                i++;
                flag=true;
                notifyAll();
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public synchronized void printLetter()
    {
        try{
            if (!flag)
            {
                wait();
            }else {
                System.out.print((char)(j+65));
                j++;
                flag=false;
                notifyAll();
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        MultiThreadPrint multiThreadPrint=new MultiThreadPrint();
        multiThreadPrint.new DigitPrint().start();
        multiThreadPrint.new LetterPrint().start();
    }

}

