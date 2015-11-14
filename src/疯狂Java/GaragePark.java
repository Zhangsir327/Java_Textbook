package 疯狂Java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangsirui on 15/10/20.
 */
public class GaragePark {
    //定义一个boolean数组来表示车库
    private boolean[] garage={true,true,true};
    //定义一个同步锁
    private final ReentrantLock lock=new ReentrantLock();
    class Driver extends Thread
    {
        @Override
        public void run() {
            for (int i=0;i<10;i++)
            {
                drive();
            }
        }
    }
    class Parker extends Thread
    {
        @Override
        public void run() {
            for (int i=0;i<10;i++)
            {
                park();
            }

        }
    }
    public synchronized void park()
    {
        try {
            for (int i=0;i<3;i++)
            {
                if (garage[i])
                {
                    lock.lock();
                    System.out.println("进行停车");
                    garage[i]=false;
                    lock.unlock();
                    notifyAll();
                }
            }
            wait();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public synchronized void drive()
    {
        try {
            for (int i=0;i<3;i++)
            {
                if (!garage[i])
                {
                    lock.lock();
                    System.out.println("开车");
                    garage[i]=true;
                    lock.unlock();
                    notifyAll();
                }
            }
            wait();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        GaragePark garagePark=new GaragePark();
        garagePark.new Parker().start();
        garagePark.new Driver().start();
    }

}
