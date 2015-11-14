package 疯狂Java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangsirui on 15/10/19.
 */
public class DrawTest {
    public static void main(String[] args)
    {
        //创建一个账户
        Account account=new Account("1234567",0);

        new DrawThread("D.Wade",account,800).start();
        new DepositThread("TMac",account,800).start();
        new DepositThread("Kobe",account,1000).start();
    }
}
class DepositThread extends Thread
{
    private Account account;
    private double depositAmount;
    public DepositThread(String name,Account account,double depositAmount)
    {
        super(name);
        this.account=account;
        this.depositAmount=depositAmount;
    }
    public void run()
    {
        for (int i=0;i<100;i++)
        {
            account.deposit(depositAmount);
        }
    }
}
class DrawThread extends Thread
{
    //模拟用户账户
    private Account account;
    //当前取钱线程所希望取的钱数
    private double drawAmount;
    public DrawThread(String name,Account account,double drawAmount)
    {
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }
    //当多个线程修改同一个共享数据时，将涉及数据安全问题
    public void run() {
       /*
        //使用共享资源Account作为同步监视器
        //任何线程进入下面同步代码块之前，必须先获得对Account账户的锁定——其他线程无法获得锁，也就无法修改它
        //这种做法符合“加锁-修改-释放锁”的逻辑
        synchronized (account)
        {
            //账户余额大于取钱数目
            if (account.getBalance()>=drawAmount)
            {
                //吐出钞票
                System.out.println(getName()+"取钱成功！吐出钞票："+drawAmount);
                try
                {
                    Thread.sleep(1);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //修改余额
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("\t余额为："+account.getBalance());
            }else {
                System.out.println(getName() + "取钱失败！余额不足");
            }
        }
        //同步代码块结束，释放同步锁
        */
        for (int i=0;i<100;i++)
        {
            account.draw(drawAmount);
        }
    }
}
class Account
{
    //定义锁对象
    private final ReentrantLock lock=new ReentrantLock();
    //获得指定lock对象的Condition
    private final Condition condition=lock.newCondition();
    //封装账户编号、账户余额的两个成员变量
    private String AccountNo;
    //标识账户中是否已有存款的旗标
    private boolean flag=false;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    private double balance;
    public Account(String AccountNo,double balance)
    {
        this.AccountNo=AccountNo;
        this.balance=balance;
    }
    public int hashCode()
    {
        return AccountNo.hashCode();
    }
    public boolean equals(Object object)
    {
        if (this==object)
            return true;
        if (object!=null&&object.getClass()==Account.class)
        {
            Account target=(Account)object;
            return target.getAccountNo().equals(AccountNo);
        }
        return false;
    }
    //还可以使用由synchronized关键字修饰的同步方法来实现线程同步
    public synchronized void draw(double drawAmount)
    {
        try{
            //如果flag为false，表示还没有人存钱进去,取钱方法阻塞
            if (!flag)
            {
                condition.await();
            }else {
                //执行取钱操作
                System.out.println(Thread.currentThread().getName()+" "+drawAmount);
                balance-=drawAmount;
                System.out.println("账户余额为：" + balance);
                //将标识账户是否已有存款的旗标设为false
                flag=false;
                //唤醒其他线程
                //notifyAll();
                condition.signalAll();
            }

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public synchronized void deposit(double depositAmount)
    {
        try{
            //如果flag为真，存钱方法阻塞
            if (flag)
            {
                condition.await();
            }else {
                //进行存款
                System.out.println(Thread.currentThread().getName()+" "+depositAmount);
                balance+=depositAmount;
                System.out.println("账户余额为：" + balance);
                flag=true;
                //notifyAll();
                condition.signalAll();
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    //加锁
    public void drawMoney(double drawAmount)
    {
        //加锁
        lock.lock();
        try{
            //账户余额大于取钱数目
            if (balance>=drawAmount)
            {
                //吐出钞票
                System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);

                //修改余额
                balance-=drawAmount;
                System.out.println("\t余额为："+balance);
            }else {
                System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足");
            }
        }
        finally {
            //修改完成，释放锁
            lock.unlock();
        }
    }
}
