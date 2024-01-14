package myfirst.multithread;
import java.lang.*;
class MyThread1 extends Thread
{
    public MyThread1(String name)
    {
        super(name);
    }
    public void run()
    {
        int count = 1;
        while (true)
        {
            System.out.println(Thread.currentThread().getName()+": " + count++);
        }
    }

}
public class ThreadTest  {
    public static void main(String[] args) throws Exception
    {
        MyThread1 mt = new MyThread1("Daemon Thread");
        mt.setDaemon(true);
        mt.start();

        System.out.println("Daemon thread finished!!");

        MyThread1 mt2 = new MyThread1("Normal Thread");

        mt2.setDaemon(true);
        mt2.start();
        mt2.interrupt();

        Thread.currentThread().join();
    }
}
